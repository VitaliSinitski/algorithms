package org.example;

public class BubbleSortTask {
    public static void main(String[] args) {
        int[] array = {3, 1, 7, 9, 9, 5, 7};
//        int counter1 = bubbleSort1(array);
        int result = bubbleSortRev(array);
        System.out.println(result);
//        System.out.println("bubbleSort1: " + counter1);
//        System.out.println(result);
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int temp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = temp;
    }

    private static int bubbleSort1(int[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    counter++;
                }
            }
        }
//        System.out.println(Arrays.toString(array));
        return counter;
    }

    private static int bubbleSortRev(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return arrayToInt(array);
    }

    // don't function
    private static int bubbleSort2(int[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[i] < array[i - 1]) {
                    swap(array, j, j - 1);
                    counter++;
                }
            }
        }
//        System.out.println(Arrays.toString(array));
        return counter;
    }

    private static int arrayToInt(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int digit : array) {
            sb.append(digit);
        }
        return Integer.parseInt(sb.toString());
    }
}
