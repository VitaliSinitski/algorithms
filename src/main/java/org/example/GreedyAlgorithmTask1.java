package org.example;

public class GreedyAlgorithmTask1 {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
//        bubbleSort(digits);
        selectSort(digits);
        int result = digitToInteger(digits);
        System.out.println(result);

    }

    private static void bubbleSort(int[] digits) {
        for(int i = digits.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (digits[j] < digits[j + 1]) {
                    swap(digits, j, j + 1);
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
    private static void selectSort(int[] digits) {
        int max;
        for (int i = 0; i < digits.length; i++) {
            max = i;
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[j] > digits[max]) {
                    max = j;
                }
            }
            swap(digits, i, max);
        }
    }

    private static int digitToInteger(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int digit : digits) {
            sb.append(digit);
        }
        String string = sb.toString();
        return Integer.parseInt(string);
    }

    private static void swap(int[] digits, int ind1, int ind2) {
        int temp = digits[ind1];
        digits[ind1] = digits[ind2];
        digits[ind2] = temp;
    }
}
