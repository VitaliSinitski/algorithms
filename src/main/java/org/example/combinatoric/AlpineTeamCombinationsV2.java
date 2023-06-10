package org.example.combinatoric;

import java.util.ArrayList;
import java.util.List;

public class AlpineTeamCombinationsV2 {
    public static void main(String[] args) {
        // Заданная группа альпинистов
        char[] alpinists = {'A', 'B', 'C', 'D', 'E'};

        // Генерация всех комбинаций из трех альпинистов
        List<String> combinations = generateCombinations(alpinists, 3);

        // Вывод списка комбинаций
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> generateCombinations(char[] alpinists, int teamSize) {
        // Базовый случай - команда размером 1
        if (teamSize == 1) {
            List<String> combinations = new ArrayList<>();
            for (char alpinist : alpinists) {
                combinations.add(String.valueOf(alpinist));
            }
            return combinations;
        }

        // Рекурсивно генерируем комбинации
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i <= alpinists.length - teamSize; i++) {
            char currentAlpinist = alpinists[i];
            char[] remainingAlpinists = new char[alpinists.length - i - 1];
            System.arraycopy(alpinists, i + 1, remainingAlpinists, 0, alpinists.length - i - 1);

            List<String> subCombinations = generateCombinations(remainingAlpinists, teamSize - 1);
            for (String subCombination : subCombinations) {
                combinations.add(currentAlpinist + subCombination);
            }
        }
        return combinations;
    }
}

