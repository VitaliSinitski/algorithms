package org.example;

/**
 * В 1626 году индейцы продали Манхэттен за 24$
 * Написать программу, которая вычислит сумму,
 * получившуюся бы в текущем году, если бы индейцы положили эти деньги в банк под 5% годовых.
 */
public class Manhattan {
    public static void main(String[] args) {
        int pastYear = 1626;
        double price = 24;
        double percent = 0.05;
        double result = sumCount(pastYear, price, percent);
        System.out.println(result);
    }

    private static double sumCount(int pastYear, double price, double percent) {
        double result = price;
        int nowYear = 2022;
        for (int currentYear = pastYear + 1; currentYear <= nowYear; currentYear++) {
            result += result * percent;
            System.out.println(result + ": " + currentYear);
        }
        return result;
    }
}
