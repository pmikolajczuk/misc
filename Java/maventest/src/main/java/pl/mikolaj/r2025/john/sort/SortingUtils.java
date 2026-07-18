package pl.mikolaj.r2025.john.sort;

import java.util.Arrays;

public class SortingUtils {
	public static void printArray(int[] numbers, int first, int last) {
		int[] tmp = Arrays.copyOfRange(numbers, first, last + 1);
		System.out.println(Arrays.toString(tmp));
	}
}
