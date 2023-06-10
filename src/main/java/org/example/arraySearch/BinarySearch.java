package org.example.arraySearch;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        int nElems = 100;
        int target = 24;
        int[] array = new int[nElems];
        arrayFill(array);
        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        selectSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
//        int result = binarySearch(array, target);
        int rankResult = rank(array, target);
//        if (result == -1) {
//            System.out.println("Result. Element didn't found");
//        } else {
//            System.out.println("Result: " + result);
//        }
        if (rankResult == -1) {
            System.out.println("Rank result. Element didn't found");
        } else {
            System.out.println("Rank result: " + rankResult);
        }

    }

    private static void arrayFill(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }

        }
    }

    private static void selectSort(int[] array) {
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

    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    /*
     * Инициализация переменных:
     *      Задаем начальное значение для переменной low, указывающей на начало массива (индекс 0).
     *      Задаем начальное значение для переменной high, указывающей на конец массива (индекс array.length - 1).
     * Цикл поиска:
     *      Пока значение low не превысит значение high, продолжаем поиск в массиве.
     *      Вычисляем средний индекс элемента массива: mid = (low + high) / 2.
     *      Сравниваем элемент в средней позиции array[mid] с искомым значением target.
     *      Если элемент в средней позиции равен target, то мы нашли искомый элемент. Возвращаем позицию mid.
     *      Если элемент в средней позиции меньше target, значит искомое значение находится в правой половине массива. Обновляем значение low = mid + 1.
     *      Если элемент в средней позиции больше target, значит искомое значение находится в левой половине массива. Обновляем значение high = mid - 1.
     * Выход из цикла:
     *      Если цикл завершается и значение low становится больше high, это означает, что искомый элемент не найден в массиве.
     *      Возвращаем -1 для обозначения того, что элемент не найден.
     */
    private static int binarySearch(int[] array, int target) {
        int low = 0;    // Задаем начальное значение для переменной low, указывающей на начало массива (индекс 0)
        int high = array.length - 1; // Задаем начальное значение для переменной high, указывающей на конец массива (индекс array.length - 1)
        while (low <= high) { // Пока значение low не превысит значение high, продолжаем поиск в массиве
            int mid = (low + high) / 2; // Вычисляем средний индекс элемента массива // 49 // 24 // 11 // 17 // 20 // 22 // 21
            if (array[mid] == target) { // Сравниваем элемент в средней позиции array[mid] с искомым значением target
                return mid;         // Если элемент в средней позиции равен target, то мы нашли искомый элемент. Возвращаем позицию mid.
            } else if (array[mid] < target) { // Если элемент в средней позиции меньше target, значит искомое значение находится в правой половине массива.
                low = mid + 1;      // Искомое значение находится в правой половине.  Обновляем значение low.
            } else { // Если элемент в средней позиции больше target, значит искомое значение находится в левой половине массива.
                high = mid - 1;     // Искомое значение находится в левой половине.  Обновляем значение high.
            }
        }   // Если цикл завершается и значение low становится больше high, это означает, что искомый элемент не найден в массиве.
        return -1;                  // Возвращаем -1 для обозначения того, что элемент не найден.
    }

    /*
     * Инициализация переменных:
     *      Задаем начальное значение для переменной low, указывающей на начало массива (индекс 0).
     *      Задаем начальное значение для переменной high, указывающей на конец массива (индекс array.length - 1).
     * Цикл поиска:
     *      Пока значение low не превысит значение high, продолжаем поиск в массиве.
     *      Вычисляем средний индекс элемента массива: mid = low + (high - low) / 2. Это предпочтительный способ вычисления среднего индекса, чтобы избежать возможной переполненности при больших значениях low и high.
     *      Сравниваем искомое значение elementToFind с элементом в средней позиции array[mid].
     *      Если elementToFind меньше array[mid], значит искомое значение находится в левой половине массива. Обновляем значение high = mid - 1.
     *      Если elementToFind больше array[mid], значит искомое значение находится в правой половине массиве. Обновляем значение low = mid + 1.
     *      Если elementToFind равно array[mid], то мы нашли искомый элемент. Возвращаем позицию mid.
     * Выход из цикла:
     *      Если цикл завершается и значение low становится больше high, это означает, что искомый элемент не найден в массиве. Возвращаем -1 для обозначения того, что элемент не найден.
     */
    public static int rank(int[] array, int elementToFind) {
        // Задаем начальное значение для переменной startIndex, указывающей на начало массива (индекс 0).
        int startIndex = 0;
        // Задаем начальное значение для переменной endIndex, указывающей на конец массива (индекс array.length - 1).
        int endIndex = array.length - 1;
        // Пока значение startIndex не превысит значение endIndex, продолжаем поиск в массиве.
        while (startIndex <= endIndex) {
            // Вычисляем средний индекс элемента массива: middleIndex = startIndex + (endIndex - startIndex) / 2.
            // Это предпочтительный способ вычисления среднего индекса, чтобы избежать возможной переполненности при больших значениях startIndex и endIndex.
            int middleIndex = startIndex + (endIndex - startIndex) / 2; // 49 // 24 // 11 // 17 // 20 // 22 // 21
            // Сравниваем искомое значение elementToFind с элементом в средней позиции array[middleIndex].
            if (elementToFind < array[middleIndex]) {
                // Если elementToFind меньше array[middleIndex], значит искомое значение находится в левой половине массива. Обновляем значение endIndex = middleIndex - 1.
                endIndex = middleIndex - 1;
                // Если elementToFind больше array[middleIndex], значит искомое значение находится в правой половине массиве. Обновляем значение startIndex = middleIndex + 1.
            } else if (elementToFind > array[middleIndex]) {
                startIndex = middleIndex + 1;
                // Если elementToFind равно array[middleIndex], то мы нашли искомый элемент. Возвращаем позицию middleIndex.
            } else {
                return middleIndex;
            }
        }
        // Если цикл завершается и значение startIndex становится больше endIndex, это означает, что искомый элемент не найден в массиве.
        // Возвращаем -1 для обозначения того, что элемент не найден.
        return -1;
    }
}
