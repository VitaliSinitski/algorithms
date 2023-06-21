package org.example.stack;

public class App {
    public static void main(String[] args) {
        SimpleStack<Character> stack = new SimpleStack<>();
        String word = "string";
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        StringBuilder rev = new StringBuilder(word);
        System.out.println(rev.reverse().toString());
    }
}
