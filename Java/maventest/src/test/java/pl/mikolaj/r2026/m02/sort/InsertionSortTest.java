package pl.mikolaj.r2026.m02.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

	int[] testNumbers = {3,1,8,6,2};

	InsertionSort insertionSort = new InsertionSort();

	@Test
	void sort() {
		System.out.println("Input: " + Arrays.toString(testNumbers));
		insertionSort.sort(testNumbers);
		System.out.println("Output: " + Arrays.toString(testNumbers));
	}
}