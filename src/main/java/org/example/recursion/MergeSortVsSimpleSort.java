package org.example.recursion;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSortVsSimpleSort {
    public static void main(String[] args) {
        int numElems = 1_000_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        long beforeSort = System.currentTimeMillis();
//        bubbleSort(numbers);
//        selectSort(numbers);
//        insertSort(numbers);
        mergeSort(numbers, 0, numbers.length - 1);
        long afterSort = System.currentTimeMillis();
//        System.out.println(Arrays.toString(numbers));
//        System.out.println("Bubble sort method took: " + (afterSort - beforeSort) + " ms"); // 40-50ms(10_000) // 9_000ms(100_000)
//        System.out.println("Select sort method took: " + (afterSort - beforeSort) + " ms"); // 25-35ms(10_000) // 2_500ms(100_000)
//        System.out.println("Insert sort method took: " + (afterSort - beforeSort) + " ms"); // 10-15ms(10_000) // 600ms(100_000)
        System.out.println("Merge sort method took: " + (afterSort - beforeSort) + " ms"); // 2-3ms(10_000) // 20ms(100_000) // 120-140ms(1_000_000)
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < 1_000_000; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1_000_000);
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /*
     * Объявляем переменную min для хранения индекса минимального элемента.
     * Внешний цикл выполняется для каждого элемента массива.
     * Внутри внешнего цикла:
     * - Инициализируем min текущим индексом i.
     * - Внутренний цикл выполняется для поиска минимального элемента среди оставшихся элементов.
     * - Если найден элемент, меньший текущего минимального, обновляем индекс min.
     * - После завершения внутреннего цикла вызываем метод swap для обмена текущего элемента с найденным минимальным элементом.
     * Повторяем эти шаги для каждого элемента, чтобы отсортировать массив по возрастанию.
     */
    private static void selectSort(int[] array) {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    /*
     * Внешний цикл начинается со второго элемента (индекс 1) и продолжается до конца массива.
     * Внутри внешнего цикла:
     * - Сохраняем текущий элемент во временной переменной temp.
     * - Инициализируем переменную j значением текущего индекса i.
     * - Внутренний цикл выполняется, пока j больше 0 и элемент array[j - 1] больше temp.
     * - Внутри внутреннего цикла сдвигаем элементы массива вправо, чтобы освободить место для вставки temp.
     * - Уменьшаем индекс j на 1, чтобы перейти к предыдущему элементу.
     * - После выхода из внутреннего цикла, вставляем temp в правильную позицию в массиве.
     * Повторяем эти шаги для каждого элемента, пока весь массив не будет отсортирован.
     */
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp){
                array[j] = array[j  - 1];
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

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j  = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int m = 0; m < temp.length; m++) {
            array[left + m] = temp[m];
        }
    }
}
