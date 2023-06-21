package org.example.stack;

import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        String input = "a{b[c]d}e"; // Пример строки

        if (checkBrackets(input)) {
            System.out.println("Скобки расставлены правильно");
        } else {
            System.out.println("Ошибка: скобки расставлены неправильно");
        }
    }

    public static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    public static boolean isCloseBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    public static boolean isMatchingPair(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')') ||
               (openBracket == '[' && closeBracket == ']') ||
               (openBracket == '{' && closeBracket == '}');
    }
}

