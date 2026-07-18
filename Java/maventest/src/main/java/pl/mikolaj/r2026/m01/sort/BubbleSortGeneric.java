package pl.mikolaj.r2026.m01.sort;

public class BubbleSortGeneric {

	public <T extends Comparable<T>> void sortV1(T[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array.length - 1; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					swap(array, j, j+1);
				}
			}
		}
	}

	public <T extends Comparable<T>> void sortV4(T[] array) {
		int maxElement = array.length;
		for(int i = 0; i < array.length; i++) {
			boolean swapped = false;
			for(int j = 0; j < maxElement - 1; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					swap(array, j, j+1);
					swapped = true;
				}
			}
			maxElement --;

			if(!swapped) {
				break;
			}
		}
	}

	private <T> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
