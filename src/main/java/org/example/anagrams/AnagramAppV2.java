package org.example.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnagramAppV2 {
    static int size;
    static char[] arrChar = new char[100];
    static List<String> anagrams = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.print("Enter a word: ");
        String input = getString();
        size = input.length();
        for (int j = 0; j < size; j++)
            arrChar[j] = input.charAt(j);
        doAnagram(size);

        System.out.println("Anagrams:");
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1)
            return;
        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2)
                addAnagram();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = arrChar[position];
        for (j = position + 1; j < size; j++)
            arrChar[j - 1] = arrChar[j];
        arrChar[j - 1] = temp;
    }

    public static void addAnagram() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < size; j++) {
            sb.append(arrChar[j]);
        }
        anagrams.add(sb.toString());
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}

