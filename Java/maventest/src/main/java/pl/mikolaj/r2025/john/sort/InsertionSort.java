package pl.mikolaj.r2025.john.sort;

public class InsertionSort {
	public static void sort(int[] numbers) {
		for(int i = 1; i < numbers.length; i++) {
			int tmp = numbers[i];
			int j = i - 1;
			for(; j >= 0 && numbers[j] > tmp; j--) {
				numbers[j + 1] = numbers[j];
 			}
			numbers[j+1] = tmp;
		}
	}
}
