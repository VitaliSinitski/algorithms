package org.example.anagrams;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String word = "cat";

        String[] strings = toStringArray(word);
        Character[] characters = toCharacterArray(word);
        char[] chars = toCharArray(word);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(characters));
        System.out.println(Arrays.toString(chars));
    }



    private static String[] toStringArray(String word) {
        String[] wordArray = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = String.valueOf(word.charAt(i));
        }
        return wordArray;
    }

    private static Character[] toCharacterArray(String word) {
        Character[] charArray = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            charArray[i] = word.charAt(i);
        }
        return charArray;
    }

    private static char[] toCharArray(String word) {
        return word.toCharArray();
    }
}
