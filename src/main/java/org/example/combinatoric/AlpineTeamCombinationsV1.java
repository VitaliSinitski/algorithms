package org.example.combinatoric;

import java.util.ArrayList;
import java.util.List;

public class AlpineTeamCombinationsV1 {
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
        List<String> combinations = new ArrayList<>();
        // Вызов вспомогательного метода для генерации комбинаций
        generateCombinationsHelper(alpinists, teamSize, 0, new char[teamSize], combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(char[] alpinists, int teamSize, int startIndex, char[] currentCombination, List<String> combinations) {
        // Базовый случай - команда сформирована
        if (teamSize == 0) {
            // Добавление комбинации в список
            combinations.add(new String(currentCombination));
            return;
        }

        for (int i = startIndex; i <= alpinists.length - teamSize; i++) {
            // Добавление текущего альпиниста в текущую комбинацию
            currentCombination[currentCombination.length - teamSize] = alpinists[i];
            // Рекурсивный вызов для формирования оставшихся альпинистов команды
            generateCombinationsHelper(alpinists, teamSize - 1, i + 1, currentCombination, combinations);
        }
    }
}
