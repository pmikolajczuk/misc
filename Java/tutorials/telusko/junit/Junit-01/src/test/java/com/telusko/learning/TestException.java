package com.telusko.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestException {

    @Test
    void testSortingArray_Exception() {
        SortingArray sortingArray = new SortingArray();
        int[] arr = null;

        assertThrows(NullPointerException.class, () -> sortingArray.sortArray(arr));
    }
}
