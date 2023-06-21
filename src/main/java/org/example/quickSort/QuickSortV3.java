package org.example.quickSort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortV3 {
    /*
    Алгоритм быстрой сортировки:
    1. Из массива выбираем некоторый опорный элемент.
    2. Перекладываем все элементы влево или вправо от опорного элемента, разбивая массив на две части:
        - неотсортированные элементы слева от опорного элемента
        - неотсортированные элементы справа от опорного элемента.
    3. Рекурсивно вызываем алгоритм для сортировки этих двух подмассивов.

    Основная функция, которую вызываем для сортировки массива:
    */
    public static void main(String[] args) {
        int numElems = 100;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    // Заполняем массив случайными числами от 0 до 99
    private static void fillArray(int[] array) {
        Arrays.fill(array, ThreadLocalRandom.current().nextInt(100));
    }

    // Основная функция быстрой сортировки
    public static void quickSort(int[] array) {
        quickSortIterative(array, 0, array.length - 1);
    }

    // Итеративная реализация алгоритма быстрой сортировки
    private static void quickSortIterative(int[] array, int leftIndex, int rightIndex) {
        // Создаем стек для хранения границ подмассивов
        int[] stack = new int[rightIndex - leftIndex + 1];

        // Инициализируем вершину стека
        int top = -1;

        // Помещаем начальные значения границ в стек
        stack[++top] = leftIndex;
        stack[++top] = rightIndex;

        // Пока стек не пуст, продолжаем извлекать границы и сортировать подмассивы
        while (top >= 0) {
            // Извлекаем правую и левую границы текущего подмассива
            rightIndex = stack[top--];
            leftIndex = stack[top--];

            // Выбираем опорный элемент
            int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];

            // Разбиваем подмассив на две части и получаем новые границы
            int partitionIndex = partition(array, leftIndex, rightIndex, pivot);

            // Если есть элементы в левой части подмассива, помещаем границы в стек
            if (partitionIndex - 1 > leftIndex) {
                stack[++top] = leftIndex;
                stack[++top] = partitionIndex - 1;
            }

            // Если есть элементы в правой части подмассива, помещаем границы в стек
            if (partitionIndex + 1 < rightIndex) {
                stack[++top] = partitionIndex + 1;
                stack[++top] = rightIndex;
            }
        }
    }

    // Разделение подмассива на две части
    private static int partition(int[] array, int leftIndex, int rightIndex, int pivot) {
        int leftMarkerIndex = leftIndex;
        int rightMarkerIndex = rightIndex;

        while (leftMarkerIndex <= rightMarkerIndex) {
            // Двигаем левый маркер вправо, пока элемент меньше опорного
            while (array[leftMarkerIndex] < pivot)
                leftMarkerIndex++;

            // Двигаем правый маркер влево, пока элемент больше опорного
            while (array[rightMarkerIndex] > pivot)
                rightMarkerIndex--;

            // Если левый маркер все еще меньше правого, меняем элементы местами
            if (leftMarkerIndex <= rightMarkerIndex) {
                swap(array, leftMarkerIndex, rightMarkerIndex);
                leftMarkerIndex++;
                rightMarkerIndex--;
            }
        }

        // Возвращаем индекс, по которому происходит разделение
        return leftMarkerIndex;
    }

    // Поменять местами элементы массива по индексам
//    private static void swap(int[] array, int index1, int index2) {
//        int temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }

    private static void swap(int[] array, int ind1, int ind2) {
        array[ind1] ^= array[ind2];
        array[ind2] ^= array[ind1];
        array[ind1] ^= array[ind2];
    }

}
