package pl.mikolaj.r2026.m02.sort;

public class SelectionSort {

	public static void sort(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
			int lowest = i;
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[j] < numbers[lowest]) {
					lowest = j;
				}
			}
			swap(i, lowest, numbers);
		}
	}

	private static void swap(int i, int j, int[] numbers) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
