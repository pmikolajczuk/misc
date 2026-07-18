package pl.mikolaj.r2026.m02.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

	int[] testNumbers = {38, 27, 43, 3, 9,82,10};

	@Test
	void sort() {
		System.out.println("Input: " + Arrays.toString(testNumbers));
		MergeSort.sort(testNumbers);
		System.out.println("Output: " + Arrays.toString(testNumbers));
	}
}