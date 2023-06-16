package org.example.recursion;

public class ArraySumRecursive {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int sum = calculateSum(array);
        System.out.println("Сумма элементов массива: " + sum);
    }

    public static int calculateSum(int[] array) {
        return calculateSumRecursive(array, 0);
    }

    /*
     * Метод calculateSumRecursive рекурсивно вызывает сам себя, увеличивая индекс,
     *      пока индекс не достигнет значения array.length.
     * Когда это происходит, мы достигли базового случая, и функция возвращает 0.
     *
     * Затем, на каждом шаге возврата из рекурсии, значение текущего элемента массива прибавляется к сумме оставшейся части массива.
     *      Это происходит в строке:
     *      return currentElement + remainingSum;
     * Таким образом, при каждом шаге рекурсии происходит накопление суммы элементов массива, начиная с последнего элемента и заканчивая первым.
     */

    private static int calculateSumRecursive(int[] array, int index) {
        if (index >= array.length) {
            return 0; // Базовый случай: сумма пустого массива равна 0
        } else {
            int currentElement = array[index];
            int remainingSum = calculateSumRecursive(array, index + 1);
            return currentElement + remainingSum; // Рекурсивный случай: сумма текущего элемента и суммы оставшейся части массива
        }
    }
}

