package org.example.anagrams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramAppV3 {
    static List<String> anagrams = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        generateAnagrams(input);

        System.out.println("Anagrams:");
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    public static void generateAnagrams(String word) {
        generateAnagramsHelper("", word);
    }

    public static void generateAnagramsHelper(String prefix, String remaining) {
        int length = remaining.length();

        if (length == 0) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < length; i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i)
                                      + remaining.substring(i + 1);
                generateAnagramsHelper(newPrefix, newRemaining);
            }
        }
    }
}

