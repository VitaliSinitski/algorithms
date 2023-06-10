package org.example;

public class FactorialOther {
    public static void main(String[] args) {
        int value = 5;
        int result = factorial(value);
        System.out.println(result);
    }

    private static int factorial(int value) {
        if (value == 1) return value;
        return value * factorial(value - 1);
    }
}