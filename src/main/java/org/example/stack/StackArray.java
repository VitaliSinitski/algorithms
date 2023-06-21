package org.example.stack;

import java.util.Arrays;

public class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // push
    public void push(int value) {
        stackArray[++top] = value;
    }

    // pop
    public int pop() {
        return stackArray[top--];
    }

    // pick
    public int pick() {
        return stackArray[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return (top == -1);
    }

    // isFull
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public String toString() {
        return Arrays.toString(stackArray);
    }
}
