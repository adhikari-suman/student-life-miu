package lab_20240415_w3d1.level_3;


import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class Level3Tests {

    @Test
    public  void clonedPositionsAreEqual() throws CloneNotSupportedException {
        // Arrange
        Position p1 = new Position("Project Manager","IT");

        // Act
        Position p2 = (Position) p1.clone();

        // Assert
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    public  void clonedEmployeesAreEqual() throws CloneNotSupportedException {
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
        Position p1 = new Position("Project Manager","IT");

        p1.setEmployee(e1);
        e1.setPosition(p1);


        // Act
        Employee e2 = (Employee) e1.clone();

        // Assert
        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }
}
