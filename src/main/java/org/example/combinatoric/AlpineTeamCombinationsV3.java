package org.example.combinatoric;

public class AlpineTeamCombinationsV3 {
    public static void main(String[] args) {
        char[] alpinists = {'A', 'B', 'C', 'D', 'E'};
        int teamSize = 3;

        generateCombinations
                (alpinists, // массив альпинистов
                teamSize,   // размер команды
                new StringBuilder(),  // текущую комбинацию
                0); // индекс, с которого начинается выбор следующего альпиниста
    }

    public static void generateCombinations (char[] alpinists, int teamSize, StringBuilder combination, int startIndex) {
        // если размер команды `teamSize` равен 0, значит комбинация уже содержит трех альпинистов
        // поэтому мы выводим комбинацию на экран и возвращаемся из метода
        if (teamSize == 0) {
            System.out.println(combination.toString()); // Выводим комбинацию
            return;
        }
        // В цикле `for` начиная с индекса `startIndex` до `alpinists.length - teamSize`,
        // мы перебираем возможных альпинистов, которых можно добавить в команду.
        for (int i = startIndex; i <= alpinists.length - teamSize; i++) {
            // в каждой итерации цикла мы добавляем текущего альпиниста в комбинацию
            combination.append(alpinists[i]);

            // вызываем рекурсивно метод `generateCombinations` для выбора оставшихся альпинистов
            generateCombinations(
                    alpinists,
                    teamSize - 1, // уменьшаем `teamSize` на 1
                    combination,
                    i + 1);     // увеличиваем `startIndex` на 1

            // удаляем последнего добавленного альпиниста из комбинации
            combination.deleteCharAt(combination.length() - 1);
        }
        // Рекурсивные вызовы будут продолжаться, пока размер команды `teamSize` не станет равным 0,
        // после чего программа вернется к предыдущему вызову и продолжит перебор других комбинаций.
        // При каждом достижении комбинации из трех альпинистов, она будет выведена на экран.
    }
}

