package org.example.quickSort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        int numElems = 1_000_000_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        long before = System.currentTimeMillis();
        sortArray(numbers);
        long after = System.currentTimeMillis();
//        System.out.println("Quick sort with recursion took: " + (after - before) + " ms"); // 800ms (10_000_000) // 8500-9500ms (100_000_000) // 95000ms (1_000_000_000)
        System.out.println("Quick sort with stack took: " + (after - before) + " ms"); // 700-750ms (10_000_000) // 7500-8500ms (100_000_000) // OutOfMemoryError: Java heap space (1_000_000_000)
    }

    public static void sortArray(int[] array) {
        quickSortRecursion(array, 0, array.length - 1);
//        quickSortIterative(array, 0, array.length - 1);
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
    private static void quickSortRecursion(int[] array, int leftIndex, int rightIndex) {
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
            quickSortRecursion(array, leftIndex, rightMarkerIndex);
        }
        if (rightIndex > leftMarkerIndex) {
            quickSortRecursion(array, leftMarkerIndex, rightIndex);
        }
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

    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private static void fillArray(int[] array) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_000_000_000);
        }
    }
}
