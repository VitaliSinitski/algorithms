package org.example;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] params) {
        int[] array = {2, 7, 9, 1, 8, 6, 4, 3, 5};
//        int[] array = {15, 78, 89, 9, 12, 12546, 8, 879, 16, 54, 1};
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid); // Сортировка левой половины массива
            mergeSort(array, mid + 1, right); // Сортировка правой половины массива
            merge(array, left, mid, right); // Слияние двух отсортированных половин
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // Создание временного массива для слияния
        int i = left; // Индекс для левой половины
        int j = mid + 1; // Индекс для правой половины
        int k = 0; // Индекс для временного массива

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i]; // Запись элемента из левой половины во временный массив
                i++; // Увеличение индекса левой половины
            } else {
                temp[k] = array[j]; // Запись элемента из правой половины во временный массив
                j++; // Увеличение индекса правой половины
            }
            k++; // Увеличение индекса временного массива
        }

        // Если остались элементы только в левой половине
        while (i <= mid) {
            temp[k] = array[i]; // Запись оставшихся элементов из левой половины во временный массив
            i++;
            k++;
        }

        // Если остались элементы только в правой половине
        while (j <= right) {
            temp[k] = array[j]; // Запись оставшихся элементов из правой половины во временный массив
            j++;
            k++;
        }

        // Копирование отсортированных элементов из временного массива обратно в исходный массив
        for (int m = 0; m < temp.length; m++) {
            array[left + m] = temp[m];
        }
    }
}

