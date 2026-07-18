package pl.mikolaj.r2026.m01.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

	int[] testNumbers1 = new int[] {7,2,3,8,9,1};

	SelectionSort selectionSort = new SelectionSort();

	@Test
	void sortV1() {
		int[] numbers = testNumbers1;
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		selectionSort.sortV1(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Steps Counter: " + selectionSort.getStepsCounter());
	}
}