package org.example.arraySearch;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchV1 {
    public static void main(String[] args) {
        int numElements = 100;
        int elementToFind = 35;
        int[] numbers = new int[numElements];
        initializeArray(numbers);
        insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Element ot find is: " + elementToFind);
        binarySearchResult(numbers, elementToFind);
    }

    private static void initializeArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ThreadLocalRandom.current().nextInt(100);
        }
    }

    private static void insertSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i;
            while (j > 0 && numbers[j - 1] > temp) {
                numbers[j] = numbers[j - 1];
                j--;
            }
            numbers[j] = temp;
        }
    }

    private static int binarySearch(int[] array, int elementToFind) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        int middleIndex;
        while (startIndex <= endIndex) {
            middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }
            if (array[middleIndex] > elementToFind) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static void binarySearchResult(int[] array, int elementToFind) {
        int result = binarySearch(array, elementToFind);
        if (result == - 1) {
            System.out.println("The searched element was not found");
        } else {
            System.out.println("The index of searched element is: " + result);
        }
    }


}
