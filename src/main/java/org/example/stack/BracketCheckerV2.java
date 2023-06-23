package org.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketCheckerV2 {
    private String input; // Входная строка

    public BracketCheckerV2(String in) {    // Конструктор
        input = in;
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.print("Enter string containing delimiters: ");
            System.out.flush();
            input = getString(); // Чтение строки с клавиатуры
            if (input.equals("")) // Завершение, если [Enter]
                break;
            // Создание объекта BracketChecker
            BracketCheckerV2 theChecker = new BracketCheckerV2(input);
            theChecker.check(); // Проверка парных скобок
        }
    }

    private static String getString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public void check() {
        int stackSize = input.length(); // Определение размера стека
        StackX theStack = new StackX(stackSize); // Создание стека
        for (int j = 0; j < input.length(); j++) // Последовательное чтение
        {
            char ch = input.charAt(j); // Чтение символа
            switch (ch) {
                case '{': // Открывающие скобки
                case '[':
                case '(':
                    theStack.push(ch); // Занести в стек
                    break;
                case '}': // Закрывающие скобки
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {  // Если стек не пуст,
                        char chx = theStack.pop(); // Извлечь и проверить
                        if ((ch == '}' && chx != '{') ||
                            (ch == ']' && chx != '[') ||
                            (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + j);
                        } else { // Преждевременная нехватка элементов
                            System.out.println("Error: " + ch + " at " + j);
                        }
                        break;
                    }
                default: // Для других символов действия не выполняются
                    break;
            }
        }
        // В этой точке обработаны все символы
        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}