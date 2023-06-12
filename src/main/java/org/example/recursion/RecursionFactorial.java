package org.example.recursion;

public class RecursionFactorial {
    public static void main(String[] args) {
        int result = factorial(9);
        System.out.println(result);
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
