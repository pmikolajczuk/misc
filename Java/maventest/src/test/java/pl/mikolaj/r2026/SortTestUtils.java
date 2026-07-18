package pl.mikolaj.r2026;

import pl.mikolaj.r2026.utils.Utils;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SortTestUtils {
	private final static int TEST_ARRAY_BOUND = 100;

	public static <T> void processSortingMethodGeneric(Consumer<T[]> sortingMethod, T[] input) {
		System.out.println("Input: " + Utils.arrayToString(input));
		//System.out.println("Is Sorted: " + SortTestUtils.isSorted(input));
		sortingMethod.accept(input);
		System.out.println("Output: " + Utils.arrayToString(input));
		//System.out.println("Is Sorted: " + SortTestUtils.isSorted(input));
	}

	public static void processSortingMethod(Consumer<int[]> sortingMethod, Supplier<Integer> stepsCounter) {
		int[] numbers = SortTestUtils.generateArray(100);
		System.out.println("Input: " + Utils.intArrayToString(numbers));
		System.out.println("Is Sorted: " + SortTestUtils.isSorted(numbers));
		sortingMethod.accept(numbers);
		System.out.println("Output: " + Utils.intArrayToString(numbers));
		System.out.println("Is Sorted: " + SortTestUtils.isSorted(numbers));
		System.out.println("Steps Counter: " + stepsCounter.get());
	}

	public static int[] generateArray(int length) {
		Random rand = new Random();
		int[] numbers = new int[length];
		for (int i = 0; i < length; i++) {
			numbers[i] = rand.nextInt(TEST_ARRAY_BOUND);
		}
		return numbers;
	}

	public static boolean isSorted(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i+1] < numbers[i]) {
				return false;
			}
		}

		return true;
	}
}
