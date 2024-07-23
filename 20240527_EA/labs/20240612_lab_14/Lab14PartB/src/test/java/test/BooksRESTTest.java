package test;

import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class BooksRESTTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .addFilter((requestSpec, responseSpec, ctx) -> {
                    System.out.println("Request URL: " + requestSpec.getURI()); // Log the request URL
                    return ctx.next(requestSpec, responseSpec);
                })
                .build();
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("878"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testGetNoBook() {
        // Arrange
        given()
                .contentType("application/json")
                .delete("/books/878");

        // Act and Assert
        given()
                .contentType("application/json")
                .get("books/878").then()
                .statusCode(404);
    }

    @Test
    public void testDeleteABook() {
        // Arrange
        Book book = new Book("878", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        // Act and Assert
        given()
                .contentType("application/json")
                .delete("/books/878").then()
                .statusCode(204);
    }

    @Test
    public void testDeleteNotExistingBook() {
        // Arrange
        Book book = new Book("879", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        // Act and Assert
        given()
                .contentType("application/json")
                .delete("/books/879").then()
                .statusCode(204);

        given()
                .contentType("application/json")
                .delete("/books/879").then()
                .statusCode(404);
    }

    @Test
    public void testAddBook() {
        // Arrange, Act and Assert
        Book book = new Book("879", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        // test getting the book
        given()
                .when()
                .get("books/879")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("879"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(18.95f))
                .body("author", equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/879");
    }

    @Test
    public void testUpdateBook() {
        // Arrange
        Book book = new Book("881", "Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        // test getting the book

        book.setAuthor("Ariel");
        book.setPrice(19.99);

        given()
                .body(book)
                .when()
                .contentType(ContentType.JSON)
                .put("/books/881")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .and()
                .body("isbn", equalTo("881"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(19.99f))
                .body("author", equalTo("Ariel"));

        //cleanup
        given()
                .when()
                .delete("/books/881");
    }

    @Test
    public void testSearchBookReturnTwoBooks() {
        // Arrange
        Book book = new Book("884", "Book 123", 18.95, "Allen Smith");
        Book book1 = new Book("885", "Book 124", 18.95, "Allen Smith");

        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books")
                .then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books")
                .then()
                .statusCode(200);

        Map<String, String> params = new HashMap<>();
        params.put("author", "Allen Smith");

        // Test getting the books
        given()
                .spec(requestSpec)
                .params(params)
                .when()
                .contentType(ContentType.JSON)
                .get("/books")
                .then()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .and()
                .body("books", hasSize(2)) // Check that the 'books' array has 2 items
                .body("books.isbn", hasItems("884", "885")) // Check that the list contains the specified ISBNs
                .body("books.title", hasItems("Book 123", "Book 124")) // Optional: check titles as well
                .body("books.author", everyItem(equalTo("Allen Smith"))); // Check that every book has the author "Allen Smith"

        // Cleanup
        given()
                .when()
                .delete("/books/884")
                .then()
                .statusCode(204);

        given()
                .when()
                .delete("/books/885")
                .then()
                .statusCode(204);
    }

}
