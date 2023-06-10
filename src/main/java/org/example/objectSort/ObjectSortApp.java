package org.example.objectSort;

import java.util.Arrays;

public class ObjectSortApp {
    private static int nElems = 5;
    private static Person[] array = new Person[nElems];
    private static int count = 0;

    public static void main(String[] args) {
        arrayFill();
        System.out.println(Arrays.toString(array));
//        arrayBubbleSort();
//        arraySelectSort();
        System.out.println("counter: " + count);
        arrayInsertSort();
        System.out.println(Arrays.toString(array));

    }

    private static void addPerson(String firstName, String lastName, int age) {
        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[count] = Person.createPerson(firstName, lastName, age);
        count++;
//        System.out.println(count);
//        System.out.println(Arrays.toString(array));
    }

    private static void arrayFill() {
        addPerson("Evans", "Patty", 24);
        addPerson("Smith", "Lorraine", 37);
        addPerson("Yee", "Tom", 43);
        addPerson("Adams", "Berry", 63);
        addPerson("Hashimoto", "Sato", 21);
        addPerson("Stimson", "Henry", 29);
        addPerson("Velasquez", "Jose", 72);
        addPerson("Lamarque", "White", 54);
        addPerson("Vang", "Minh", 22);
        addPerson("Creswell", "Lucinda", 18);
    }

    /*
     * Внешний цикл выполняется для прохода по элементам массива с конца до второго элемента.
     * Внутренний цикл выполняется для сравнения пар соседних элементов.
     * Если текущий элемент больше следующего элемента, вызывается метод swap для их обмена.
     * После завершения внутреннего цикла наибольший элемент смещается в конец массива.
     * Внешний цикл повторяется, уменьшая длину прохода на каждой итерации.
     * Повторяем эти шаги до тех пор, пока массив не будет полностью отсортирован по возрастанию.
     */
    private static void arrayBubbleSort() {
        for(int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compare(array[j], array[j + 1]) > 0) {
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
    private static void arraySelectSort() {
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compare(array[j], array[min]) < 0) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    /*
     * Внешний цикл начинается со второго элемента (индекс 1) и продолжается до конца массива.
     * (Условие цикла изменено на i < count, а не i < array.length, чтобы проходить только по заполненным элементам массива.)
     * Внутри внешнего цикла:
     * - Сохраняем текущий элемент во временной переменной temp.
     * - Инициализируем переменную j значением текущего индекса i.
     * - Внутренний цикл выполняется, пока j больше 0 и элемент array[j - 1] больше temp.
     * - Внутри внутреннего цикла сдвигаем элементы массива вправо, чтобы освободить место для вставки temp.
     * - Уменьшаем индекс j на 1, чтобы перейти к предыдущему элементу.
     * - После выхода из внутреннего цикла, вставляем temp в правильную позицию в массиве.
     * Повторяем эти шаги для каждого элемента, пока весь массив не будет отсортирован.
     */
    private static void arrayInsertSort() {
        for (int i = 1; i < count; i++) {
            Person temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1].compare(array[j - 1], temp) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

//    private static void arrayInsertSort() {
//        for (int i = 1; i < array.length; i++) {
//            Person temp = array[i];
//            int j = i;
//            while(j > 0 && array[j - 1].compare(array[j -1], temp) > 0) {
//                array[j] = array[j - 1];
//                j--;
//            }
//            array[i] = temp;
//        }
//    }


    private static void swap(int ind1, int ind2) {
        Person temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

}
