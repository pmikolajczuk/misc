package com.telusko.learning;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBeforeAfter {

    Shapes shapes;

    TestBeforeAfter() {
        System.out.println("Constructor");
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    void setUp() {
        shapes = new Shapes();
        System.out.println("Before each");
    }

    @AfterEach
    void tearDown() {
        shapes = null;
        System.out.println("After each");
    }

    @Test
    void testComputeSquareArea() {
        System.out.println("Test case for computeSquareArea");
        assertEquals(25.0, shapes.computeSquareArea(5.0), 0.001);

    }

    @Test
    void testComputeCircleArea() {
        System.out.println("Test case for computeCircleArea");
        assertEquals(78.53981633974483, shapes.computeCircleArea(5.0), 0.001);
    }
}
