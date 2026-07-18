package pl.mikolaj.old.john.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = Utils.generateArray(100000);
        System.out.println("Before: ");
        Utils.printArray(numbers);

        bubbleSort(numbers);
        System.out.println("After:");
        Utils.printArray(numbers);
    }

    private static void bubbleSort(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            boolean swapped = false;
            for(int j = 1; j < numbers.length; j++) {
                if(numbers[j-1] > numbers[j]){
                    int tmp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = tmp;
                    swapped = true;
                }
            }
            if(! swapped) {
                System.out.println("i = " + i);
                break;
            }
        }
    }
}
