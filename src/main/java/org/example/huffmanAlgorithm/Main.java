package org.example.huffmanAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
//        String text = "where there's a will there's a way";
        String text = "What is fucking going on?";

        // вычисляем частоты символов в тексте
        TreeMap<Character, Integer> frequencies = HuffmanAlgorithm.countFrequency(text);

        // Для того что бы алгоритм Хаффмана запустить, нам нужно сгенерировать список узлов для листов дерева,
        // к которому мы потом будем применять алгоритм Хаффмана.
        ArrayList<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }

        // вызовем метод реализующий алгоритм Хаффмана и построим кодовое дерево
        // передаем массив узлов и получаем оптимальное кодовое дерево
        CodeTreeNode tree = HuffmanAlgorithm.huffman(codeTreeNodes);

        // с помощью кодового дерева нужно сгенерировать коды для каждого символа
        // будет коды хранить в виде строки с 0 и 1, что бы не возиться с отдельными битами
        // Для этого создадим map, где ключом будет символ, а данными будет строка содержащая 1 и 0,
        // которые являются кодом этого символа из кодового дерева
        TreeMap<Character, String> codes = new TreeMap<>();
        // и теперь для каждого символа
        for (Character c : frequencies.navigableKeySet()) {
            // интегрируем метод getCodeForCharacter() для генерации кода символов
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        // напечатаем таблицу префиксных кодов
        System.out.println("Таблица префиксных кодов: " + codes.toString());

        // закодируем исходную строку с помощью кодов
        StringBuilder encoded = new StringBuilder();
        // будем идти по строке и для каждого символа записывать код этого символа, который мы сгенерировали с помощью кодового дерева
        for (int i = 0; i < text.length(); i++) {
            encoded.append(codes.get(text.charAt(i)));
            // таким образов в StringBuilder у нас накопится строка, записанная 0 и 1 с помощью кодов
        }

        System.out.println("Размер исходной строки: " + text.getBytes().length * 8 + "  бит");
        System.out.println("Размер сжатой строки: " + encoded.length() + "  бит");
        System.out.println("Биты сжатой строки: " + encoded);

        String decoded = HuffmanAlgorithm.huffmanDecode(encoded.toString(), tree);
        System.out.println("Расшифровано: " + decoded);

    }





}
