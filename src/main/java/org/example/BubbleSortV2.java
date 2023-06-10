package org.example;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortV2 {

    public static void main(String[] args) {
        BubbleSortV2 bubbleSort = new BubbleSortV2();
        int nElems = 20;
        int[] array = new int[nElems];
        bubbleSort.arrayFill(array);
        System.out.println(Arrays.toString(array));
        bubbleSort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
