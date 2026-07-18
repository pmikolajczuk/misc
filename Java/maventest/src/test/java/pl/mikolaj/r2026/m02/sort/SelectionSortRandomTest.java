package pl.mikolaj.r2026.m02.sort;

import org.junit.jupiter.api.Test;
import pl.mikolaj.r2026.SortTestUtils;
import pl.mikolaj.r2026.utils.Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

public class SelectionSortRandomTest {

	@Test
	void sort() {
		processSortingMethod(SelectionSort::sort);
	}

	private void processSortingMethod(Consumer<int[]> sortingMethod) {
		int[] numbers = generateNumbers(100, 200);
		System.out.println("Input: " + Arrays.toString(numbers));
		System.out.println("Is Sorted: " + isSorted(numbers));
		sortingMethod.accept(numbers);
		System.out.println("Output: " + Arrays.toString(numbers));
		System.out.println("Is Sorted: " + isSorted(numbers));
	}

	private int[] generateNumbers(int bound, int size) {
		int[] numbers = new int[size];
		Random rand = new Random();

		for(int i = 0; i < size; i++) {
			numbers[i] = rand.nextInt(bound);
		}

		return numbers;
	}

	private boolean isSorted(int[] numbers) {
		for(int i = 0; i < numbers.length - 1; i++) {
			if(numbers[i+1] < numbers[i]) {
				return false;
			}
		}
		return true;
	}
}
