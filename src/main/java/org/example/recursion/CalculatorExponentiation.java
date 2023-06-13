package org.example.recursion;

import java.util.Scanner;

public class CalculatorExponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int exponent = scanner.nextInt();
        scanner.close();

        int exponentiation = exponentiation(num, exponent);
        System.out.println(exponentiation);
    }

    private static int exponentiation(int num, int exponent) {
        if (exponent == 0) return 1;
        return num * exponentiation(num, exponent - 1);
    }
}
