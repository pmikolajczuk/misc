package pl.mikolaj.r2026.m01.sort;

import pl.mikolaj.r2026.utils.Utils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
	private int stepsCounter;

	public int getStepsCounter() {
		return stepsCounter;
	}

	public void sortV1(int[] numbers) {
		resetStepsCounter();
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length - 1; j++) {
				stepsCounter++;
				if(numbers[j] > numbers[j+1]) {
					swap(numbers,j, j+1);
				}
			}
		}
	}

	public void sortV2(int[] numbers) {
		resetStepsCounter();

		for(int i = 0; i < numbers.length; i++) {
			boolean swapped = false;
			for(int j = 0; j < numbers.length - 1; j++) {
				stepsCounter++;
				if(numbers[j] > numbers[j+1]) {
					swap(numbers,j, j+1);
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public void sortV3(int[] numbers) {
		resetStepsCounter();
		int maxElement = numbers.length;
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < maxElement - 1; j++) {
				stepsCounter++;
				if(numbers[j] > numbers[j+1]) {
					swap(numbers,j, j+1);
				}
			}
			maxElement --;
		}
	}

	public void sortV4(int[] numbers) {
		resetStepsCounter();

		int maxElement = numbers.length;
		for(int i = 0; i < numbers.length; i++) {
			boolean swapped = false;
			for(int j = 0; j < maxElement - 1; j++) {
				stepsCounter++;
				if(numbers[j] > numbers[j+1]) {
					swap(numbers,j, j+1);
					swapped = true;
				}
			}
			maxElement --;
			if (!swapped) {
				break;
			}
		}
	}

	public void sortV5(int[] numbers) {
		Integer[] boxed = IntStream.of(numbers).boxed().toArray(Integer[]::new);
		BubbleSortGeneric bubbleSortGeneric = new BubbleSortGeneric();
		bubbleSortGeneric.sortV4(boxed);
		System.out.println("Sorted: " + Utils.arrayToString(boxed));
	}

	private void resetStepsCounter() {
		stepsCounter = 0;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
