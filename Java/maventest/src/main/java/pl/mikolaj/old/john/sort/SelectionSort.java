package pl.mikolaj.old.john.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = Utils.generateArray(100000);
        System.out.print("Before: ");
        Utils.printArray(numbers);
        System.out.print("After: ");
        selectionSort(numbers);
        Utils.printArray(numbers);

    }

    private static void selectionSort(int[] numbers) {
        for(int i = 0; i < numbers.length - 1; i++) {
            int min = findMinValueIndex(numbers, i);
            swap(numbers, i, min);
        }
    }

    private static int findMinValueIndex(int[] numbers, int startIndex) {
        int min = startIndex;
        for(int i = startIndex + 1; i < numbers.length; i++) {
            if(numbers[i] < numbers[min]) {
                min = i;
            }
        }
        return min;
    }

    private static void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
