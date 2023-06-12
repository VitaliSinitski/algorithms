package org.example.stepik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while (scanner.hasNext()) {
            result += scanner.nextInt();
        }
        System.out.println(result);
    }
}
