package pl.mikolaj.r2025.john.sort;

public class SelectionSort {
	public static void sort(int[] numbers) {
		for (int j = 0; j < numbers.length; j++) {
			int lowest = j;
			for (int i = j + 1; i < numbers.length; i++) {
				if (numbers[i] < numbers[lowest]) {
					lowest = i;
				}
			}
			//swap lowest & j, will do nothing if lowest == j
			int tmp = numbers[j];
			numbers[j] = numbers[lowest];
			numbers[lowest] = tmp;
		}
	}
}
