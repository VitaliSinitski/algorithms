package org.example.arraySearch;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchRecursionV1 {
    public static void main(String[] args) {
        int numElements = 100;
        int[] numbers = new int[numElements];
        int elementToFind = 41;
        initializeArray(numbers);
        insertSort(numbers);
        System.out.println(Arrays.toString(numbers));
        searchResult(numbers, elementToFind);
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

    public static void searchResult(int[] array, int elementToFind) {
        int result = binarySearch(array, elementToFind);
        if (result == - 1) {
            System.out.println("The searched element was not found");
        } else {
            System.out.println("The index of searched element is: " + result);
        }
    }

    public static int binarySearch(int[] array, int elementToFind) {
        return binarySearchRecursive(array, 0, array.length - 1, elementToFind);
    }

    private static int binarySearchRecursive(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) {
                return middleIndex;
            }
            if (array[middleIndex] > elementToFind) {
                return binarySearchRecursive(array, startIndex, middleIndex - 1, elementToFind);
            } else {
                return binarySearchRecursive(array, middleIndex + 1, endIndex, elementToFind);
            }
        }
        return - 1;
    }


}
