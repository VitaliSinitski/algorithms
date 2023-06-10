package org.example;

public class Factorial {
    public static void main(String[] args) {
        int fac = 6;
        int result = factorial(fac);
        int resultWhile = whileFactorial(fac);
        System.out.println(result);
        System.out.println(resultWhile);
    }

    private static int whileFactorial(int fac) {
        int result = 1;
        int currentValue = 1;
        while (currentValue <= fac) {
            result *= currentValue;
            currentValue++;
        }
        return result;
    }

    private static int factorial(int fac) {
        // 8! = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;
        // 7! = 7 * 6 * 5 * 4 * 3 * 2 * 1;
        // 6! = 6 * 5 * 4 * 3 * 2 * 1;
        // 5! = 5 * 4 * 3 * 2 * 1;
        // 0! = 1;
        // 1! = 1;
        if (fac == 0 || fac == 1) return 1;
        int result = 1;
//        for (int i = fac; i >= 1; i--) {
//            result *= i;
//        }
        for (int currentValue = 1; currentValue <= fac; currentValue++) {
            result *= currentValue;
        }
        return result;
    }
}
