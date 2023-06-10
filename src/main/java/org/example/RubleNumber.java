package org.example;

public class RubleNumber {
    public static void main(String[] args) {
        int ruble = 11;
        // 1, 21, 31 ... рубль
        // 2, 3, 4, 22, 23, 24 рубля
        // 5 - 20, 25 - 30, 35 -40 ... рублей
        int remainderTen = ruble % 10;
        int remainderHundret = ruble % 100;

        if (remainderTen == 0 || (5 <= remainderTen && remainderTen <= 9) || (11 <= remainderHundret && remainderHundret <= 19)) {
            System.out.println(ruble + " рублей");
        } else if (2 <= remainderTen && remainderTen <= 4) {
            System.out.println(ruble + " рубля");
        } else if (remainderTen == 1) {
            System.out.println(ruble + " рубль");
        } else {
            System.out.println("Ruble value in not correct");
        }

    }

}
