package org.example.partition;

import java.util.Arrays;

public class DataPartitioning {
    public static void main(String[] args) {
        int[] data = {8, 3, 10, 5, 2, 7, 1, 6, 4, 9};
        int threshold = 6;

        System.out.println("Исходный массив: " + Arrays.toString(data));
        partitionData(data, threshold);

        System.out.println("Группа 1 (Значение ключа >= " + threshold + "): " + Arrays.toString(data));
        System.out.println("Группа 2 (Значение ключа < " + threshold + "): " + Arrays.toString(data));
    }

    private static void partitionData(int[] data, int threshold) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            while (data[left] < threshold) {
                left++;
            }

            while (data[right] >= threshold) {
                right--;
            }

            if (left <= right) {
                swap(data, left, right);
                left++;
                right--;
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

