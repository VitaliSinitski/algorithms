package org.example.recursion;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        int sum = mult(num1, num2);
        System.out.println(sum);
    }

    private static int mult(int num1, int num2) {
        if (num2 == 0) return 0;
        return num1 + mult(num1, num2 -1);
    }


}
