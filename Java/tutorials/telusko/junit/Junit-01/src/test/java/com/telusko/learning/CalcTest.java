package com.telusko.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void divide() {
        assertEquals(2, new Calc().divide(4, 2));
        assertEquals(3, new Calc().divide(9, 3));
        assertEquals(5, new Calc().divide(10, 2));
    }
}