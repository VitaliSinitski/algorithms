package org.example;

public class NumberTask {
    public static void main(String[] args) {
        int number = 233;
        boolean result = numberThree(number);
        System.out.println(result);
    }

    private static boolean numberThree(int number) {
        if (number < 0) number *= -1;
        if (number % 10 == 3) {
            return true;
        }
        return false;
    }
}
