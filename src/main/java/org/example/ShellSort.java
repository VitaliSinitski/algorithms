package org.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ShellSort {
    public static void main(String[] args) {
        int numElems = 10_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        shellSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    /*
     * Shell sort - представляет собой улучшенный вариант сортировки вставками, который выполняет множество сравнений и обменов элементов.
     * Он использует метод "сортировки с убывающим шагом" (diminishing increment sort).
     * Идея заключается в том, чтобы сначала сортировать элементы, находящиеся на большом расстоянии друг от друга,
     *      а затем постепенно уменьшать это расстояние, пока не достигается окончательная сортировка.
     *
     * 1. Инициализация переменной `step` как половины длины массива (`array.length / 2`).
     * 2. Вход в цикл `while`, который будет выполняться до тех пор, пока значение `step` больше 0.
     * 3. Вход во внутренний цикл `for`, который выполняется для каждого элемента массива начиная с `step`-го индекса.
     * 4. В каждой итерации цикла `for` выполняются следующие действия:
     *     - Создается переменная `j` и инициализируется ей значением `i`.
     *     - Вход во внутренний цикл `while`, который выполняется до тех пор, пока `j` больше или равно `step` и элемент `array[j]` меньше элемента `array[j - step]`.
     *     - В каждой итерации цикла `while` выполняются следующие действия:
     *         - Вызывается метод `swap` для обмена элементов `array[j]` и `array[j - step]`.
     *         - Значение `j` уменьшается на `step`.
     * 5. Уменьшение значения `step` в два раза (`step /= 2`).
     * 6. Возврат к шагу 4, если значение `step` больше 0.
     *
     */
    public static void shellSort(int[] array) {
        int step = array.length / 2;
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                while (j >= step && array[j] < array[j - step]) {
                    swap(array, j, j - step);
                    j -= step;
                }
            }
            step /= 2;
        }
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(10_000);
        }
    }
}
