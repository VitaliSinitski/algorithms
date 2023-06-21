package org.example.quickSort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortV1 {
    /*
    Алгоритм быстрой сортировки:
    1. Из массива выбираем некоторый опорный элемент.
    2. Перекладываем все элементы влево или вправо от опорного элемента.
       Тем самым массив разбивается на две части:
       - неотсортированные элементы слева от опорного элемента.
       - неотсортированные элементы справа от опорного элемента.
    3. Для сортировки этих двух меньших подмассивов алгоритм рекурсивно вызывает сам себя.
    */

    public static void main(String[] args) {
        int numElems = 20;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        sortArray(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    // Заполняет массив случайными числами
    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(20);
        }
    }

    // Метод для запуска алгоритма быстрой сортировки
    public static void sortArray(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Рекурсивный метод быстрой сортировки
    private static void quickSort(int[] array, int leftIndex, int rightIndex) {
        // Завершение рекурсии, если массив пуст или нет элементов для сортировки
        if (array == null || array.length == 0 || leftIndex >= rightIndex) {
            return;
        }

        // 1. Выбираем опорный элемент
        int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];
        // Создаем каретки-маркеры, которые будут отслеживать проход по элементам (инициализируются они начальным и конечным индексом в массиве)
        // каретка для прохода слева-направо до опорного элемента
        int leftMarkerIndex = leftIndex;
        // каретка для прохода справа-налево до опорного элемента
        int rightMarkerIndex = rightIndex;

        // алгоритм будет работать пока левая каретка <= правой каретке
        while (leftMarkerIndex <= rightMarkerIndex) {
            // 2. Перекладываем все элементы влево или вправо от опорного элемента
            // Двигаем левый маркер слева направо, если элемент меньше опорного
            while (array[leftMarkerIndex] < pivot) {
                leftMarkerIndex++;
            }
            // Двигаем правый маркер, если элемент больше опорного
            while (array[rightMarkerIndex] > pivot) {
                rightMarkerIndex--;
            }
            // Если левый маркер все еще меньше правого, меняем элементы местами
            if (leftMarkerIndex <= rightMarkerIndex) {
                swap(array, leftMarkerIndex, rightMarkerIndex);
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }

        // 3. Рекурсивный вызов для сортировки левой и правой частей
        // Если есть левый подмассив (от начала до правого маркера, прошедшего в середину)
        if (leftIndex < rightMarkerIndex) {
            quickSort(array, leftIndex, rightMarkerIndex);
        }
        // Если есть правый подмассив (от конца до левого маркера, прошедшего в середину)
        if (rightIndex > leftMarkerIndex) {
            quickSort(array, leftMarkerIndex, rightIndex);
        }
    }

    // Метод для обмена элементами массива
    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
