package lab_20240415_w3d1.level_1;


import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.SQLOutput;
import java.time.LocalDate;


public class Level1Tests {

    @Test
    public void testTwoEmployeesEqual() {
        // Arrange
        Employee e1 = new Employee(
                1,
                "Ariel",
                null,
                "Adhikari",
                LocalDate.of(1997, 1, 12),
                "123-245-111", 12400,
                null
        );

        Employee e2 = new Employee(
                1,
                "Ariel",
                null,
                "Adhikari",
                LocalDate.of(1997, 1, 12),
                "123-245-111", 12400,
                null
        );

        // Act


        // Assert
         assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
        assertEquals(e1.toString(), e2.toString());
    }

    @Test
    public void testTwoEmployeesNotEqual() {
        // Arrange
        Employee e1 = new Employee(
                1,
                "Ariel",
                null,
                "Adhikari",
                LocalDate.of(1997, 1, 12),
                "123-245-111", 12400,
                null
        );

        Employee e2 = new Employee(
                2,
                "Aung",
                null,
                "Kyaw Myint",
                LocalDate.of(1997, 1, 12),
                "123-245-111", 24400,
                null
        );

        // Act


        // Assert
        assertFalse(e1.equals(e2));
        assertFalse(e1.hashCode() == e2.hashCode());
        assertFalse(e1.toString().equals(e2.toString()));
    }

    @Test
    public void twoPositionsAreEqual() {
        // Arrange
        Position p1 = new Position(
                "title1", "position1"
        );

        Position p2 = new Position(
                "title1", "position1"
        );

        // Act

        // Assert
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p1.toString(), p2.toString());
    }

    @Test
    public void twoPositionsAreNotEqual() {
        // Arrange
        Position p1 = new Position(
                "title1", "position1"
        );

        Position p2 = new Position(
                "title2", "position2"
        );

        // Act

        // Assert
        assertFalse(p1.equals(p2));
        assertFalse(p1.hashCode() == p2.hashCode());
        assertFalse(p1.toString().equals(p2.toString()));
    }


    @Test
    public void twoDepartmentsAreEqual() {
        // Arrange
        Department d1 = new Department("IT", "Iowa");
        Department d2 = new Department("IT", "Iowa");

        // Act

        // Assert
        assertEquals(d1, d2);
        assertEquals(d1.hashCode(), d2.hashCode());
        assertEquals(d1.toString(), d2.toString());
    }

    @Test
    public void twoDepartmentsAreNotEqual() {
        // Arrange
        Department d1 = new Department("IT", "Iowa");
        Department d2 = new Department("Sales", "Iowa");

        // Act

        // Assert
        assertFalse(d1.equals(d2));
        assertFalse(d1.hashCode() == d2.hashCode());
        assertFalse(d1.toString().equals(d2.toString()));
    }
}
