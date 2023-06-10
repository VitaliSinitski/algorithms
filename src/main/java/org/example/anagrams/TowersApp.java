package org.example.anagrams;

import java.util.Scanner;

public class TowersApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nDisks = scanner.nextInt();
        if (nDisks > 0) {
            doTowers(nDisks, 'A', 'B', 'C'); // Вызываем метод для решения головоломки
        } else {
            System.out.println("Number of disks should be a positive integer."); // Выводим сообщение об ошибке, если количество дисков не является положительным числом
        }
    }

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Move disk from " + from + " to " + to); // Базовый случай: перемещение одного диска с одного стержня на другой
        } else {
            // Рекурсивный случай: перемещение (topN-1) дисков с одного стержня на другой с использованием третьего стержня в качестве промежуточного
            doTowers(topN - 1, from, to, inter);
            System.out.println("Move disk " + topN + " from " + from + " to " + to); // Перемещение последнего диска с одного стержня на другой
            // Перемещение (topN-1) дисков с промежуточного стержня на конечный с использованием первого стержня в качестве промежуточного
            doTowers(topN - 1, inter, from, to);
        }
    }
}

