package org.example.quickSort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortS {
    public static void main(String[] args) {
        int numElems = 10_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        sortArray(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sortArray(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /*
        Метод quickSort(int[] array, int leftIndex, int rightIndex):

        1. Условие: Завершить (или выход из рекурсии) если массив пуст или нечего делить (leftIndex >= rightIndex)
            - Из массива выбираем некоторый опорный элемент.
                - Тем самым массив разбивается на две части:
                    - неотсортированные элементы слева от опорного элемента
                    - неотсортированные элементы справа от опорного элемента
            - Создаем каретки-маркеры, которые будут отслеживать проход по элементам (инициализируются они начальным и конечным индексом в массиве)
                - каретка для прохода слева-направо до опорного элемента
                - каретка для прохода справа-налево до опорного элемента
        2. Условие: алгоритм будет работать пока левая каретка <= правой каретке
            - Перекладываем все элементы влево или вправо от опорного элемента.
                - Двигаем левый маркер слева направо, если элемент меньше опорного
                - Двигаем правый маркер, если элемент больше опорного
            - Если левый маркер все еще меньше правого, меняем элементы местами
                - Сдвигаем маркеры, чтобы получить новые границы
        3. Рекурсивный вызов для сортировки левой и правой частей
            - Если есть левый подмассив (от начала до правого маркера, прошедшего в середину)
            - Если есть правый подмассив (от конца до левого маркера, прошедшего в середину)
    */
    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        if (array == null || array.length == 0 || leftIndex >= rightIndex) return;
        int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;

        while (leftMarkerIndex <= rightMarkerIndex) {
            while (array[leftMarkerIndex] < pivot) {
                leftMarkerIndex++;
            }
            while (array[rightMarkerIndex] > pivot) {
                rightMarkerIndex--;
            }
            if (leftMarkerIndex <= rightMarkerIndex) {
                swap(array, leftMarkerIndex, rightMarkerIndex);
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }

        if (leftIndex < rightMarkerIndex) {
            quickSort(array, leftIndex, rightMarkerIndex);
        }
        if (rightIndex > leftMarkerIndex) {
            quickSort(array, leftMarkerIndex, rightIndex);
        }

    }

    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private static void fillArray(int[] array) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10_000);
        }
    }
}
