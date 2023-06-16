package org.example.recursion;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ArraySum {
    public static void main(String[] args) {
        int numElems = 10;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        System.out.println(Arrays.toString(numbers));
        int result = sumArray(numbers);
        System.out.println(result);
    }

    private static void fillArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(10);
        }
    }

    private static int sumArray (int[] array) {
        return sumArrayRecursion(array, 0);
    }

    private static int sumArrayRecursion(int[] array, int index) {
        if (index >= array.length) return 0;
        int currentNum = array[index];
        int sum = sumArrayRecursion(array, index + 1);
        return currentNum + sum;
    }
}
