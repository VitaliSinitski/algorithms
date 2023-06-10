package org.example;

/**
 * Имеется целое число. Посчитать сумму цифр данного числа.
 */
public class SumNumber {
    public static void main(String[] args) {
        int number = -123456;
        int result = sumNumber(number);
        int resultWhile = sumNumberWhile(number);
        System.out.println(result);
        System.out.println(resultWhile);
    }

    private static int sumNumberWhile(int number) {
        int result = 0;
        int currentValue = (number > 0 ? number : number * -1);
        while (currentValue > 0) {
            int remainder = currentValue % 10;
            result += remainder;
            currentValue /= 10;
        }
        return result;
    }


    private static int sumNumber(int number) {
        int result = 0;
//        if (number < 0) number *= -1;
        for (int currentValue = (number > 0 ? number : number * -1); currentValue > 0; currentValue /= 10) {
            int remainder = currentValue % 10;
            result += remainder;
        }
//        int division = 1;
//        while (division > 0) {
//            division = number / 10;
//            int remainder = number % 10;
//            result += remainder;
//        }
        return result;
    }
}
