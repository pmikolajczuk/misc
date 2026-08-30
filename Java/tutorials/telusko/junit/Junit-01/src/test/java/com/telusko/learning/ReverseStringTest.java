package com.telusko.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString reverseString = new ReverseString();

    @Test
    void reverseString_OneWord() {
        assertEquals("olleh", reverseString.reverseString("hello"));
        assertEquals("dlrow", reverseString.reverseString("world"));
    }

    @Test
    void reverseString_MultipleWords() {
        assertEquals("dlrow olleh", reverseString.reverseString("hello world"));
        assertEquals("gnimmargorp avaJ", reverseString.reverseString("Java programming"));
    }
}