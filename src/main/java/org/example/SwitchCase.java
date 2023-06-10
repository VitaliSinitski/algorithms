package org.example;

public class SwitchCase {
    public static void main(String[] args) {
        int month = 4;
        String result = null;
        if (month == 12 || month == 1 || month == 12) {
            result = "winter";
        } else if (3 <= month && month <= 5) {
            result = "spring";
        } else if (month == 6 || month == 7 || month == 8) {
            result = "summer";
        } else if (month == 9 || month == 10 || month == 11) {
            result = "autumn";
        } else {
            result = "month number is not correct";
        }
//        String result = switch (month) {
//            case 12, 1, 2 -> "winter";
//            case 9, 10, 11 -> "autumn";
//            case 6, 7, 8 -> "summer";
//            case 3, 4, 5 -> "spring";
//            default -> "the month number is invalid";
//        };

        System.out.println(result);
    }
}
