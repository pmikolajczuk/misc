package pl.mikolaj.old.john.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = Utils.generateArray(10_000_000);
        //int[] numbers = {3, 1};//, 8, 6, 2};
        System.out.println("Before: ");
        //Utils.printArray(numbers);

        mergeSortV2(numbers);
        System.out.println("After:");
        //Utils.printArray(numbers);
    }

    private static void mergeSort(int[] numbers) {
        if (numbers.length == 1) {
            return;
        }
        int middle = numbers.length / 2;
        int[] left = Arrays.copyOfRange(numbers, 0, middle);
        int[] right = Arrays.copyOfRange(numbers, middle, numbers.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, numbers);
    }

    private static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        for (; i < left.length && j < right.length; k++) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
        }

        for (; i < left.length; i++, k++) {
            result[k] = left[i];
        }

        for (; j < right.length; j++, k++) {
            result[k] = right[j];
        }
    }

    private static void mergeSortV2(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int first, int last) {
        if (first == last) {
            return;
        }
        int middle = (first + last) / 2;
        sort(numbers, first, middle); //sort left
        sort(numbers, middle + 1, last); //sort right
        merge(numbers, first, middle, last);
    }

    private static void merge(int[] numbers, int first, int middle, int last) {
        int[] left = copyOfRange(numbers, first, middle + 1);
        int[] right = copyOfRange(numbers, middle + 1, last + 1);

        int i = 0, j = 0, k = first;
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
        while (i < left.length) {
            numbers[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            numbers[k] = right[j];
            j++;
            k++;
        }
    }

    private static int[] copyOfRange(int[] numbers, int first, int last) {
        int[] result = new int[last - first];
        for (int i = first; i < last; i++) {
            result[i - first] = numbers[i];
        }
        return result;
    }
}
