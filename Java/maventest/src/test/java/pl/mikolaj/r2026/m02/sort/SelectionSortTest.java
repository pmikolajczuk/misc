package pl.mikolaj.r2026.m02.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

	int[] testNumbers1 = {4,5,1,2,3};

	@Test
	void sort() {
		int[] numbers = testNumbers1;
		System.out.println("Input: " + Arrays.toString(numbers));
		SelectionSort.sort(numbers);
		System.out.println("Output: " + Arrays.toString(numbers));
	}
}