package pl.mikolaj.r2026.m02.sort;

public class InsertionSort {

	private int counter = 0;

	public int getCounter() {
		return counter;
	}

	public void sort(int[] numbers) {
		counter = 0;

		for(int i = 1 ; i < numbers.length; i++) {
			int tmp = numbers[i];
			int j = i - 1;
			for(;j >= 0; j--) {
				counter++;
				if(numbers[j] > tmp) {
					numbers[j+1] = numbers[j];
				} else {
					break;
				}
			}
			numbers[j+1] = tmp;
		}
	}
}
