package pl.mikolaj.r2026.m02.sort;

import java.util.Arrays;

public class MergeSort {

	public static void sort(int[] numbers) {
		sort(0, numbers.length - 1, numbers);
	}

	private static void sort(int beginning, int end, int[] numbers) {
		if (beginning == end) {
			return;
		}

		int middle = (beginning + end) / 2;

		sort(beginning, middle, numbers);
		sort(middle + 1, end, numbers);

		int[] left = Arrays.copyOfRange(numbers, beginning, middle + 1);
		int[] right = Arrays.copyOfRange(numbers, middle + 1, end + 1);

		int i = 0, j = 0, k = beginning;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				numbers[k] = left[i];
				i++;
			} else {
				numbers[k] = right[j];
				j++;
			}
			k++;
		}

		while(i < left.length) {
			numbers[k] = left[i];
			i++;
			k++;
		}

		while(j < right.length) {
			numbers[k] = right[j];
			j++;
			k++;
		}
	}
}
