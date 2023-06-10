package org.example.arraySearch;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int nElems = 100;
        int target = 24;
        int[] array = new int[nElems];
        arrayFill(array);
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println(Arrays.toString(array));
        int result = binarySearchRecursive(array, target);
        System.out.println(result);
    }

    private static void arrayFill(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(100);
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

    /*
     * В публичном методе binarySearchRecursive(int[] array, int target) вызывается приватный метод binarySearchRecursive
     *      с параметрами array, target, 0 (начальная нижняя граница) и array.length - 1 (начальная верхняя граница).
     * В приватном методе binarySearchRecursive(int[] array, int target, int low, int high) сначала проверяется условие if (low > high).
     *      Если нижняя граница low становится больше верхней границы high, это означает, что элемент не найден, и возвращается -1.
     * Если условие if не выполняется, то вычисляется средний индекс mid по формуле low + (high - low) / 2.
     *      Это позволяет найти индекс элемента в середине текущего подмассива.
     * Сравнивается значение элемента array[mid] с целевым значением target.
     *      Если они равны, то элемент найден, и возвращается его позиция mid.
     * Если array[mid] меньше target, то искомое значение находится в правой половине подмассива.
     *      В этом случае метод вызывается рекурсивно для правой половины подмассива с новыми границами mid + 1 и high.
     * Если array[mid] больше target, то искомое значение находится в левой половине подмассива.
     *      В этом случае метод вызывается рекурсивно для левой половины подмассива с границами low и mid - 1.
     * Если ни одно из условий не выполняется, то рекурсивный вызов продолжается до тех пор,
     *      пока не будет найден элемент или пока границы low и high не пересекутся.
     * Если элемент не найден, метод возвращает -1.
     */

    /*
     * В данном случае используются два метода для рекурсивного двоичного поиска в массиве.
     * Это делается для того, чтобы позволить внешнему коду вызывать только один публичный метод binarySearchRecursive(int[] array, int target),
     *      скрывая детали рекурсивной реализации.
     *
     * Приватный метод binarySearchRecursive(int[] array, int target, int low, int high) служит вспомогательным методом,
     *      который рекурсивно вызывает сам себя для выполнения поиска в подмассивах.
     * Это позволяет осуществить рекурсивный двоичный поиск с указанием границ подмассивов low и high.
     *
     * Использование двух методов обеспечивает лучшую абстракцию и чистоту кода.
     * Публичный метод binarySearchRecursive(int[] array, int target) скрывает детали рекурсивной реализации от вызывающего кода
     *      и предоставляет более удобный интерфейс для выполнения поиска.
     *
     * Если требуется, можно внести все в один метод, но это усложнит читаемость и понимание кода.
     * При использовании двух методов, каждый из них выполняет свою конкретную задачу, что делает код более структурированным и понятным.
     */

    public static int binarySearchRecursive(int[] array, int target) {
        // вызывается приватный метод binarySearchRecursive с параметрами array, target, 0 (начальная нижняя граница) и array.length - 1 (начальная верхняя граница).
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }



    private static int binarySearchRecursive(int[] array, int target, int low, int high) {
        // сначала проверяется условие if (low > high)
        if (low > high) {
        // если нижняя граница low становится больше верхней границы high, это означает, что элемент не найден, и возвращается -1
            return -1;
        }
        // если условие if не выполняется, то вычисляется средний индекс mid по формуле low + (high - low) / 2
        int mid = low + (high - low) / 2;
        // сравнивается значение элемента array[mid] с целевым значением target
        if (array[mid] == target) {
        // если они равны, то элемент найден, и возвращается его позиция mid
            return mid;
        // если array[mid] меньше target, то искомое значение находится в правой половине подмассива
        } else if (array[mid] < target) {
        // в этом случае метод вызывается рекурсивно для правой половины подмассива с новыми границами mid + 1 и high
            return binarySearchRecursive(array, target, mid + 1, high); // Искомое значение находится в правой половине
        // если array[mid] больше target, то искомое значение находится в левой половине подмассива
        } else {
        // в этом случае метод вызывается рекурсивно для левой половины подмассива с границами low и mid - 1
            return binarySearchRecursive(array, target, low, mid - 1); // Искомое значение находится в левой половине
        }
        // Если ни одно из условий не выполняется, то рекурсивный вызов продолжается до тех пор,
        // пока не будет найден элемент или пока границы low и high не пересекутся.
        // Если элемент не найден, метод возвращает -1.
    }

}
