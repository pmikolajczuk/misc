package pl.mikolaj.r2026.m01.sort;

public class SelectionSort {

	private int stepsCounter;

	public int getStepsCounter() {
		return stepsCounter;
	}

	public void sortV1(int[] numbers) {
		stepsCounter = 0;
		for (int i = 0; i < numbers.length; i++) {
			int minElement = i;
			for (int j = i + 1; j < numbers.length; j++) {
				stepsCounter++;
				if (numbers[j] < numbers[minElement]) {
					minElement = j;
				}
			}
			swap(numbers, i, minElement);
		}
	}

	private void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
