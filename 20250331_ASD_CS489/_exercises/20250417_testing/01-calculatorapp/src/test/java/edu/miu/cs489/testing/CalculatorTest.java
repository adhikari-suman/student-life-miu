package edu.miu.cs489.testing;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Before every test");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("After every test");
    }

    @Test
    @Order(6`)
    void add() {
        System.out.println("Addition test");
    }

    @Test
    @Order(2)
    void sub() {
        System.out.println("Subtraction test");
    }

    @Test
    @Order(3)
    void mul() {
        System.out.println("Multiplication test");
    }
}