package pl.mikolaj.r2025.john.sort;

import java.util.Arrays;

public class MergeSort {
	public static void sort(int[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}

	private static void sort(int[] numbers, int first, int last) {
		//System.out.print("Sort: ");
		//SortingUtils.printArray(numbers, first, last);
		if (first == last) {
			return;
		}

		int mid = (first + last) / 2;
		sort(numbers, first, mid);
		sort(numbers, mid + 1, last);
		merge(numbers, first, mid, last);

	}

	private static void merge(int[] numbers, int first, int mid, int last) {
		int[] left = Arrays.copyOfRange(numbers, first, mid + 1);
		int[] right = Arrays.copyOfRange(numbers, mid + 1, last + 1);

		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			k = i + j + first;
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i++;
			} else {
				numbers[k] = right[j];
				j++;
			}
		}

		for (;i < left.length;i++) {
			k = i + j + first;
			numbers[k] = left[i];
		}

		for (;j < right.length;j++) {
			k = i + j + first;
			numbers[k] = right[j];
		}

		//System.out.print("Merged: ");
		//SortingUtils.printArray(numbers, first, last);
	}
}
