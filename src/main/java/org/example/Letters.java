package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Написать программу, которая проходит циклом по английскому алфавиту,
 * начиная с буквы 'b', и выводит каждую букву до тех пор,
 * пока не встретит гласную (т.е. вывести согласные на консоль).
 */
public class Letters {
    public static void main(String[] args) {
        char letter = 'k';
        printLetters(letter);
    }

    private static void printLetters(char letter) {
        for (char currentChar = letter; !isVowel(currentChar) ; currentChar++) {
            System.out.println(currentChar);
        }
    }

    private static boolean isVowel(char currentChar) {
        String vowelRegex = "[aeiouAEIOU]";
        Pattern pattern = Pattern.compile(vowelRegex);
        String letterString = Character.toString(currentChar);
        Matcher matcher = pattern.matcher(letterString);
        return matcher.matches();
    }
}
