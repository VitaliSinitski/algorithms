package org.example.anagrams;

import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {
    public static void main(String[] args) {
        String word = "cat";
        List<String> anagrams = generateAnagrams(word);

        System.out.println("Список анаграмм для слова " + word + ":");
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    /*
     * Здесь определяется метод generateAnagrams, который принимает слово в качестве аргумента и возвращает список строк (анаграмм).
     * Мы создаем пустой список anagrams, а затем вызываем вспомогательный метод generateAnagramsHelper,
     *      передавая пустую строку в качестве префикса, заданное слово word и список anagrams.
     * Наконец, мы возвращаем список anagrams сгенерированных анаграмм.
     */
    public static List<String> generateAnagrams(String word) {
        List<String> anagrams = new ArrayList<>();
        generateAnagramsHelper("", word, anagrams);
        return anagrams;
    }

    // Первоначальный вызов generateAnagramsHelper("", "cat", anagrams) передает пустую строку в качестве префикса,
    //     слово "cat" как оставшуюся часть и пустой список анаграмм anagrams.
    //                                             ( "",                 "cat",              anagrams)
    private static void generateAnagramsHelper(String prefix, String remaining, List<String> anagrams) {
        int length = remaining.length();
        // Длина оставшейся части слова "cat" равна 3, и условие if (length == 0) не выполняется. Мы переходим к циклу for.
        if (length == 0) {
            anagrams.add(prefix);
        } else {
            // В первой итерации цикла for мы вызываем generateAnagramsHelper("c", "at", anagrams).
            //      Здесь "c" добавляется к префиксу, а оставшаяся часть слова становится "at".
            // Для второй итерации цикла for вызывается generateAnagramsHelper("a", "ct", anagrams).
            //      Здесь "a" добавляется к префиксу, а оставшаяся часть слова становится "ct".
            // Для третьей итерации цикла for вызывается generateAnagramsHelper("t", "ca", anagrams).
            //      Здесь "t" добавляется к префиксу, а оставшаяся часть слова становится "ca".
            // Теперь мы рассмотрим вызовы generateAnagramsHelper для слов "at", "ct" и "ca" аналогичным образом.
            // Каждый вызов рекурсивно генерирует анаграммы для соответствующих префиксов и оставшихся частей слова.
            // Когда длина оставшейся части слова становится равной нулю, выполняется условие if (length == 0).
            // На этом этапе мы достигли полной анаграммы. Префикс добавляется в список анаграмм anagrams с помощью метода anagrams.add(prefix).
            for (int i = 0; i < length; i++) {
                generateAnagramsHelper(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), anagrams);
            }
            // После завершения всех рекурсивных вызовов возвращается управление обратно в предыдущие вызовы рекурсии,
            // и происходят оставшиеся итерации циклов for, где строятся другие комбинации символов.
        }
    }
}
