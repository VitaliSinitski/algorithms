package org.example.stack;

import java.util.Arrays;

public class StackApp {
    public static void main(String[] args) {
        StackArray stack = new StackArray(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());
        System.out.println(stack.toString());
    }
}
