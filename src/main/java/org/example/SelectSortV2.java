package org.example;

import java.util.Arrays;
import java.util.Random;

public class SelectSortV2 {
    public static void main(String[] args) {
        SelectSortV2 selectSort = new SelectSortV2();
        int nElems = 20;
        int[] array = new int[nElems];
        selectSort.arrayFill(array);
        System.out.println(Arrays.toString(array));
        selectSort.selSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void selSort(int[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    private void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }
}
