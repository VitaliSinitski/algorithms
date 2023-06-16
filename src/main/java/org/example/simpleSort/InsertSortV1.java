package org.example.simpleSort;

import java.util.Arrays;
import java.util.Random;

public class InsertSortV1 {
    public static void main(String[] args) {
        InsertSortV1 insertSort = new InsertSortV1();
        int nElems = 20;
        int[] array = new int[nElems];
        insertSort.arrayFill(array);
        System.out.println(Arrays.toString(array));
        insertSort.insSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private void insSort(int[] array) {
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
}
