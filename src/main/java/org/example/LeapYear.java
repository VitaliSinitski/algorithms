package org.example;

public class LeapYear {
    public static void main(String[] args) {
//        int year = 2000;
        int year = 1992;
//        int year = 1900;
//         leap: year % 4 == 0; year % 100 = 0 && !year % 400 == 0;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + ": is leap year");
        } else {
            System.out.println(year + ": is not leap year");
        }
//        if (year % 4 != 0 || year % 400 == 0) {
//            System.out.println(year + ": is not leap year");
//        } else {
//            System.out.println(year + ": is leap year");
//        }
    }
}