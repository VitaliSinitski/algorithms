package org.example.arraySearch;

import java.util.Arrays;
import java.util.Random;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = new int[100];
        int searchNumber = 5;
        arrayFill(array);
        System.out.println(Arrays.toString(array));
        int index = lineSearch(array, searchNumber);
        if (index == -1) {
            System.out.println("Value didn't found");
        } else {
            System.out.println(index);
        }
    }

    private static void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = random.nextInt(10);
        }
    }

    private static int lineSearch(int[] array, int number) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
