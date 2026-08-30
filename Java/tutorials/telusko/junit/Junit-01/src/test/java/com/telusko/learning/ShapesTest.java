package com.telusko.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapesTest {
    Shapes shapes = new Shapes();

    @Test
    public void testComputeSquareArea() {
        assertEquals(576, shapes.computeSquareArea(24));
    }

    @Test
    public void testComputeCircleArea() {
        assertEquals(78.54, shapes.computeCircleArea(5), 0.01, () -> "Circle area calculation is incorrect");
    }
}
