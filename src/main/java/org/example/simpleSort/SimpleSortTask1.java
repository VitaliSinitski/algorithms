package org.example.simpleSort;

import java.util.Arrays;
import java.util.Random;

public class SimpleSortTask1 {
    private static int nElems = 10;
    private static int[] array = new int[nElems];
    private static int count = 0;

    public static void main(String[] args) {
//        long beforeArrayFill = System.currentTimeMillis();
        arrayFill();
//        long afterArrayFill = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
//        System.out.println("Sorting took time: " + (afterArrayFill - beforeArrayFill) + " ms"); // 1-2 ms
        long beforeSort = System.currentTimeMillis();
//        bubbleSort();
//        selectSort();
        insertSort();
        long afterSort = System.currentTimeMillis();
//        System.out.println("Bubble sorting took time: " + (afterSort - beforeSort) + " ms"); // 60-80 ms(10.000) / 10.000-11.000 ms(100.000)
//        System.out.println("Select sorting took time: " + (afterSort - beforeSort) + " ms"); // 40-60 ms(10.000) / 2.4-2.5 ms(100.000)
        System.out.println("Insert sorting took time: " + (afterSort - beforeSort) + " ms"); // 10-20 ms(10.000) / 550-570 ms(100.000)
//        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }

    private static void arrayFill() {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            if (count == array.length) {
                array = Arrays.copyOf(array, array.length * 2);
            }
            array[i] = random.nextInt(1000);
            count++;
        }
        array = Arrays.copyOf(array, 100_000);
//        System.out.println("array.length: " + array.length);
//        System.out.println("counter: " + count);
    }

    private static void bubbleSort() {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private static void selectSort() {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(i, min);
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
    private static void insertSort() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while(j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private static void swap(int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }
}
