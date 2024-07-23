package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Book extends Product {

    @Column(nullable = false, length = 255)
    private String isbn;

    public Book() {
    }

    public Book(String productNumber, String name, double price, String isbn) {
        super(productNumber, name, price);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                "} " + super.toString();
    }
}
