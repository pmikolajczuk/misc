package pl.mikolaj.r2025.john.sort;

public class BubbleSort {

	public static void sort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			boolean swapped = false;
			for (int j = 0; j < numbers.length - 1; j++) {
				if (numbers[j] > numbers[j+1]) {
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tmp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}
}
