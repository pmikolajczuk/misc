package pl.mikolaj.old.john.sort;

import java.util.Random;

public class Utils {
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] numbers = new int[size];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10);
        }
        return numbers;
    }

    public static void printArray(int[] numbers) {
        for(int number : numbers){
            System.out.print(number + ", ");
        }
        System.out.println();
    }

    public static void printArray(int[] numbers, int first, int last) {
        for(int i = first; i <= last; i++){
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }
}
