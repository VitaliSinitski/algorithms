package org.example.simpleSort;

public class SimpleSortTask2 {
    private static int nElems = 100_000;
    private static int[] array = new int[nElems];
    private static int counter = 0;

    public static void main(String[] args) {
        arrayFill();
//        System.out.println("array.length: " + array.length);
//        System.out.println(Arrays.toString(array));
        long beforeSorting = System.currentTimeMillis();
//        bubbleSort();
//        selectSort();
        insertSort();
        long afterSorting = System.currentTimeMillis();
//        System.out.println(Arrays.toString(array));
//        System.out.println("Bubble sorting took time: " + (afterSorting - beforeSorting) + " ms"); // 1.800-1.900ms (100.000)
//        System.out.println("Select sorting took time: " + (afterSorting - beforeSorting) + " ms"); // 2.800-2.900ms (100.000)
        System.out.println("Insert sorting took time: " + (afterSorting - beforeSorting) + " ms"); // 1.000-1.200ms (100.000)
    }

    private static void arrayFill() {
        for (int i = 99_999; i >= 0; i--) {
            array[counter] = i;
            counter++;
        }
    }

    /*
     * Внешний цикл выполняется для прохода по элементам массива с конца до второго(или первого) элемента.
     * Внутренний цикл выполняется для сравнения пар соседних элементов.
     * Если текущий элемент больше следующего элемента, вызывается метод swap для их обмена.
     * После завершения внутреннего цикла наибольший элемент смещается в конец массива.
     * Внешний цикл повторяется, уменьшая длину прохода на каждой итерации.
     * Повторяем эти шаги до тех пор, пока массив не будет полностью отсортирован по возрастанию.
     */
    private static void bubbleSort() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1);
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
