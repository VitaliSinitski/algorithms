package org.example.recursion;

import java.util.Arrays;

public class MergeSortV1 {
    // Главный метод программы
    public static void main(String[] args) {
        int[] array = {5, 1, 12, -5, 6, 10, 3};
        System.out.println("Unsorted array: " + Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // Метод для сортировки массива слиянием
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // Находим середину массива

            mergeSort(array, left, mid); // Рекурсивно сортируем левую половину массива
            mergeSort(array, mid + 1, right); // Рекурсивно сортируем правую половину массива

            merge(array, left, mid, right); // Объединяем две отсортированные половины массива
        }
    }

    // Метод для объединения двух отсортированных половин массива
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1; // Размер левой половины массива
        int n2 = right - mid; // Размер правой половины массива

        int[] leftArray = new int[n1]; // Создаем временный массив для левой половины
        int[] rightArray = new int[n2]; // Создаем временный массив для правой половины

        // Копируем элементы во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Инициализируем индексы для объединения временных массивов
        int i = 0; // Индекс для левой половины
        int j = 0; // Индекс для правой половины
        int k = left; // Индекс для основного массива

        // Объединяем временные массивы в основной массив в правильном порядке
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы из левой половины (если есть)
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы из правой половины (если есть)
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

