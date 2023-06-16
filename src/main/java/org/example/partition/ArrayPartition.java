package org.example.partition;

import java.util.Random;

class ArrayPartition {
    private long[] array;
    private int size;

    public ArrayPartition(int maxSize) {
        array = new long[maxSize];
        size = 0;
    }

    public void insert(long value) {
        array[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int partition(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;

        while (true) {
            while (leftPtr < right && array[++leftPtr] < pivot)
                ;
            while (rightPtr > left && array[--rightPtr] > pivot)
                ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}


