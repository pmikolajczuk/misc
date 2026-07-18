package pl.mikolaj.r2026.m01.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.utils.Utils;


class BubbleSortTest {

	int[] testNumbers1 = new int[] {7,2,3,8,9,1};
	int[] testNumbers2 = new int[] {2,3,1,7,8,9};
	int[] testNumbers3 = new int[] {1,2,3,7,8,9};


	BubbleSort bubbleSort = new BubbleSort();

	@Test
	void sortV1() {
		int[] numbers = testNumbers3;
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		bubbleSort.sortV1(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Steps Counter: " + bubbleSort.getStepsCounter());
	}

	@Test
	void sortV2() {
		int[] numbers = testNumbers3;
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		bubbleSort.sortV2(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Steps Counter: " + bubbleSort.getStepsCounter());
	}

	@Test
	void sortV3() {
		int[] numbers = testNumbers3;
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		bubbleSort.sortV3(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Steps Counter: " + bubbleSort.getStepsCounter());
	}

	@Test
	void sortV4() {
		int[] numbers = testNumbers3;
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		bubbleSort.sortV4(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Steps Counter: " + bubbleSort.getStepsCounter());
	}
}