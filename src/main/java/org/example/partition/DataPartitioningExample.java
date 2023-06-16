package org.example.partition;

import java.util.Arrays;

import java.util.Arrays;

public class DataPartitioningExample {
    public static void main(String[] args) {
        int[] data = {8, 3, 10, 5, 2, 7, 1, 6, 4, 9};
        int threshold = 6;

        System.out.println("Исходный массив: " + Arrays.toString(data));
        int partitionIndex = partitionData(data, threshold);

        int[] group1 = Arrays.copyOfRange(data, 0, partitionIndex);
        int[] group2 = Arrays.copyOfRange(data, partitionIndex, data.length);

        System.out.println("Группа 1 (Значение ключа >= " + threshold + "): " + Arrays.toString(group1));
        System.out.println("Группа 2 (Значение ключа < " + threshold + "): " + Arrays.toString(group2));
    }

    private static int partitionData(int[] data, int threshold) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            while (left <= right && data[left] < threshold) {
                left++;
            }

            while (left <= right && data[right] >= threshold) {
                right--;
            }

            if (left < right) {
                swap(data, left, right);
            }
        }

        return left;
    }

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}

