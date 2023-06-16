package org.example.quickSort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSortV2 {
    /*
    1. Из массива выбираем некоторый опорный элемент
    2. Перекладываем все элементы влево либо вправо от опорного элемента
        Тем самым массив разбивается на 2 части:
        - не отсортированные элементы слева от разрешающего элемента
        - не отсортированные элементы справа от разрешающего элемента
    3. Что бы отсортировать эти 2 меньших подмассива, алгоритм рекурсивно вызывает сам себя.
     */
    public static void main(String[] args) {
        int numElems = 100;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        quickSort(numbers);
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(100);
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        // завершить (выход из рекурсии) если массив пуст или нечего делить
        if (array.length == 0 || leftIndex >= rightIndex) return;

        // 1. выбираем опорный элемент
        int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;

        while (leftMarkerIndex <= rightMarkerIndex) {
            // 2. Перекладываем все элементы влево либо вправо от опорного
            // двигаем левый маркер слева направо, если элемент меньше чем pivot
            while (array[leftMarkerIndex] < pivot) leftMarkerIndex++;
            // двигаем правый маркер, если элемент больше чем pivot
            while (array[rightMarkerIndex] > pivot) rightMarkerIndex++;
            // слева уперлись в несоответствие и справа уперлись в несоответствие
            // если левый маркер все еще меньше правого, меняем элементы местами
            if (leftMarkerIndex <= rightMarkerIndex) {
                swap(array, leftMarkerIndex, rightMarkerIndex);
                // сдвигаем маркеры, что бы получить новые границы
                leftMarkerIndex++;
                rightMarkerIndex++;
            }
        }

        // 3. рекурсия для сортировки левой и правой части


    }

    private static void swap (int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
