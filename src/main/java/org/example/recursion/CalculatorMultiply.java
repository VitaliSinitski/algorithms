package org.example.recursion;

import java.util.Scanner;

public class CalculatorMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки
        int num2 = scanner.nextInt();
        scanner.nextLine(); // Считываем символ новой строки

        int result = mult(num1, num2);
        System.out.println(result);
    }

    private static int mult(int num1, int num2) {
        if (num2 == 0) return 0;
        int multiply = mult(num1, num2 - 1);
//        System.out.println(multiply);
        return num1 + multiply;
    }
}
