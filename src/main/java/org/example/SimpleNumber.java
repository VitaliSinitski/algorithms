package org.example;

/**
 * Определить, является ли введенное число простым.
 * То есть делиться без остатка только на 1 и на само себя.
 */
public class SimpleNumber {
    public static void main(String[] args) {
        int number = 18;
        boolean result = isSimple(number);
        System.out.println(result);
    }

    private static boolean isSimple(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

