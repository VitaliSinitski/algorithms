package org.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RadixSort {
    public static void main(String[] args) {
        int numElems = 1_000_000_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
//        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        long before = System.currentTimeMillis();
        radixSort(numbers);
        long after = System.currentTimeMillis();
        System.out.println("Radix sort took: " + (after - before) + " ms"); // 360ms (10_000_000) // 3500-4000ms (100_000_000) // OutOfMemoryError: Java heap space (1_000_000_000)
//        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));
    }

    private static void fillArray(int[] array) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_000_000_000);
        }
    }

    public static void radixSort(int[] arr) {
        // Находим максимальное число в массиве, чтобы определить количество цифр
        int max = Arrays.stream(arr).max().getAsInt();

        // Выполняем сортировку для каждой цифры от младшей к старшей
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Вспомогательный массив для сохранения отсортированных элементов
        int[] count = new int[10]; // Массив для подсчета частоты цифр

        // Подсчитываем частоту каждой цифры
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Преобразуем count[i] так, чтобы count[i] содержал позицию i в output массиве
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Построение отсортированного массива
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копируем отсортированный массив обратно в исходный массив
        System.arraycopy(output, 0, arr, 0, n);
    }
}
