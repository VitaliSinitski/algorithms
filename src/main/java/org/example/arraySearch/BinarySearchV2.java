package org.example.arraySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchV2 {
    public static void main(String[] args) {
        int nElems = 100;
        int target = 24;
        int[] array = new int[nElems];
        arrayFill(array);
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        int result = rank(array, target);
        if (result == -1) {
            System.out.println("Element didn't found");
        } else {
            System.out.println("Position: " + result);
        }

    }

    private static void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public static int rank(int[] array, int elementToFind) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            // Если elementToFind меньше array[middleIndex], значит искомое значение находится в левой половине массива
            // 49 // 24 // 11 // 17 // 20 // 22 // 21
            // 49 // 24 // 11 // 17 // 20 // 22 // 23
            // 49 // 24 // 36 // 30 // 27 // 28 // 29
            if (elementToFind < array[middleIndex]) {
                endIndex = middleIndex - 1;
            // Если elementToFind больше array[middleIndex], значит искомое значение находится в правой половине массиве
            } else if (elementToFind > array[middleIndex]) {
                startIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }
        // Если цикл завершается и значение startIndex становится больше endIndex, это означает, что искомый элемент не найден в массиве
        return -1;
    }
}
