package pl.mikolaj.old.john.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = Utils.generateArray(10);
        //int[] numbers = {3, 2, 1};
        //int[] numbers = {1, 8, 3, 9, 4, 5, 7};
        System.out.println("Before: ");
        Utils.printArray(numbers);

        quickSortV2(numbers, 0, numbers.length - 1);
        System.out.println("After: ");
        Utils.printArray(numbers);
    }

    private static void quickSortV2(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        int pivotIndex = partition(numbers, lowIndex, highIndex);

        quickSortV2(numbers, lowIndex, pivotIndex - 1);
        quickSortV2(numbers, pivotIndex + 1, highIndex);
    }

    private static int partition(int[] numbers, int lowIndex, int highIndex) {
        int pivot = numbers[highIndex];
        int lp = lowIndex, rp = highIndex;

        while (lp < rp) {
            if (numbers[lp] > pivot) {
                while (numbers[rp] >= pivot && lp < rp) {
                    rp--;
                }
                swap(numbers, lp, rp);
            } else {
                lp++;
            }
        }
        swap(numbers, lp, highIndex);
        return lp;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static void quickSort(int[] numbers, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivot = numbers[highIndex];
        int[] partitioned = new int[highIndex - lowIndex + 1];
        int pivotIndex;

        int j = 0;
        for (int i = lowIndex; i < highIndex; i++) {
            if (numbers[i] <= pivot) {
                partitioned[j] = numbers[i];
                j++;
            }
        }
        partitioned[j] = pivot;
        pivotIndex = j;
        j++;

        for (int i = lowIndex; i < highIndex; i++) {
            if (numbers[i] > pivot) {
                partitioned[j] = numbers[i];
                j++;
            }
        }
        quickSort(partitioned, 0, pivotIndex - 1);
        quickSort(partitioned, pivotIndex + 1, partitioned.length - 1);

        for (int i = lowIndex; i <= highIndex; i++) {
            numbers[i] = partitioned[i - lowIndex];
        }
    }
}
