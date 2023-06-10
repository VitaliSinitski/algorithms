package org.example.combinatoric;

import java.util.ArrayList;
import java.util.List;

public class AlpineTeamCombinationsV2Expl {
    public static void main(String[] args) {
        // массив `alpinists` содержит имена альпинистов
        // `teamSize` равно 3 (требуемый размер команды)
        char[] alpinists = {'A', 'B', 'C', 'D', 'E'};

        // генерация всех комбинаций из трех альпинистов
        // вызываем функцию `generateCombinations` с исходными данными (`alpinists` и `teamSize`).
        List<String> combinations = generateCombinations(alpinists, 3);

        // Вывод списка комбинаций
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<String> generateCombinations(char[] alpinists, int teamSize) {
        // Проверяем базовый случай: если `teamSize` равно 0,
        //    это означает, что мы сформировали команду нужного размера.
        //    В этом случае, создаем строку из выбранных альпинистов и добавляем ее в список `combinations`
        if (teamSize == 0) {
            return new ArrayList<>(); // Возвращаем пустой список, если teamSize = 0
        }

        // Базовый случай - команда размером 1
        if (teamSize == 1) {
        // Создается новый список `combinations`, который будет содержать комбинации альпинистов.
            List<String> combinations = new ArrayList<>();
        // Для каждого альпиниста в массиве `alpinists` создается отдельная комбинация
        //        и добавляется в список `combinations`.
            for (char alpinist : alpinists) {
                combinations.add(String.valueOf(alpinist));
            }
            return combinations;
        }

        // Рекурсивно генерируем комбинации

        // Создается новый список `combinations`, который будет содержать комбинации альпинистов.
        List<String> combinations = new ArrayList<>();
        // Выполняется цикл `for`, перебирающий индексы альпинистов от 0 до `alpinists.length - teamSize`.
        // Это нужно для того, чтобы каждый альпинист мог быть начальным в комбинации,
        //        и остальные альпинисты использовались для создания подкомбинаций.
        for (int i = 0; i <= alpinists.length - teamSize; i++) {
        // в каждой итерации цикла выбирается текущий альпинист (`currentAlpinist`) по индексу `i`
            char currentAlpinist = alpinists[i];
        // Создается новый массив `remainingAlpinists`, содержащий оставшихся альпинистов после текущего альпиниста.
            char[] remainingAlpinists = new char[alpinists.length - i - 1];
            System.arraycopy(alpinists, i + 1, remainingAlpinists, 0, alpinists.length - i - 1);
        // Рекурсивно вызывается метод `generateCombinations` для массива `remainingAlpinists`
        //        и команды размера на 1 меньше (`teamSize - 1`).
            List<String> subCombinations = generateCombinations(remainingAlpinists, teamSize - 1);
        // Полученные подкомбинации (`subCombinations`) объединяются с текущим альпинистом
        //        (`currentAlpinist`) и добавляются в список `combinations`.
            for (String subCombination : subCombinations) {
                combinations.add(currentAlpinist + subCombination);
            }
        }
        // после завершения цикла возвращается список `combinations`
        return combinations;
    }
}

