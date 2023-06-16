package org.example.shellSort;

import java.util.concurrent.ThreadLocalRandom;

public class ModifiedShellSort {
    public static void main(String[] args) {
        int numElems = 100_000_000;
        int[] numbers = new int[numElems];
        fillArray(numbers);
        long before = System.currentTimeMillis();
//        shellSort(numbers);
        modShellSort(numbers, new KnuthStep(numbers));
        long after = System.currentTimeMillis();
//        System.out.println("Shell sort took: " + (after - before) + " ms"); // 125-140ms (1_000_000) // 1750-1800ms (10_000_000) // 27s (100_000_000)
        System.out.println("Knuth shell sort took: " + (after - before) + " ms"); // 115-135ms (1_000_000) // 1600-1700ms (10_000_000) // 24.5s (100_000_000) - 10%
    }

    public static void modShellSort(int[] array, StepGenerator stepGen) {
        int step = stepGen.nextStep();
        for (; step > 0; ) {
            for (int i = step; i < array.length; i++) {
                for (int j = i; j >= step && array[j] < array[j - step]; j -= step) {
                    int temp = array[j];
                    array[j] = array[j - step];
                    array[j - step] = temp;
                }
            }
            step = stepGen.nextStep();
        }
    }

//    public static void modShellSort(int[] array, StepGenerator stepGen) {
//        int step = stepGen.nextStep();
//        while (step > 0) {
//            for (int i = step; i < array.length; i++) {
//                int j = i;
//                while (j >= step && array[j] < array[j - step]) {
//                    swap(array, j, j - step);
//                    j -= step;
//                }
//            }
//            step /= 2;
//        }
//    }

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
            array[i] = ThreadLocalRandom.current().nextInt(100_000_000);
        }
    }
}
