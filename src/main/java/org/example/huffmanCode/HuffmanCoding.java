package org.example.huffmanCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
    // Метод для построения таблицы кодирования Хаффмана
    public static Map<Character, String> buildHuffmanCodes(String text) {
        // Шаг 1: Подсчет частоты символов в тексте
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Шаг 2: Создание приоритетной очереди и добавление узлов дерева Хаффмана
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue(), null, null));
        }

        // Шаг 3: Создание дерева Хаффмана путем объединения узлов с наименьшей частотой
        while (priorityQueue.size() > 1) {
            HuffmanNode leftNode = priorityQueue.poll();
            HuffmanNode rightNode = priorityQueue.poll();
            HuffmanNode mergedNode = new HuffmanNode('\0', leftNode.frequency + rightNode.frequency, leftNode, rightNode);
            priorityQueue.offer(mergedNode);
        }

        // Получение корня дерева Хаффмана
        HuffmanNode root = priorityQueue.poll();

        // Шаг 4: Присвоение двоичных кодов символам
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    // Рекурсивный метод для присвоения кодов символам в дереве Хаффмана
    private static void buildCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodes) {
        // Если узел является листовым, присваиваем ему код
        if (node.isLeafNode()) {
            huffmanCodes.put(node.character, code);
        } else {
            // Рекурсивно вызываем метод для каждого потомка, добавляя "0" к коду для левого потомка и "1" для правого потомка
            buildCodes(node.left, code + "0", huffmanCodes);
            buildCodes(node.right, code + "1", huffmanCodes);
        }
    }

    // Метод для кодирования текста с использованием таблицы кодирования Хаффмана
    public static String encode(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }
        return encodedText.toString();
    }

    // Метод для декодирования закодированного текста с использованием дерева Хаффмана
    public static String decode(String encodedText, HuffmanNode root) {
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode currentNode = root;
        for (char bit : encodedText.toCharArray()) {
            // Если бит равен '0', переходим к левому потомку
            if (bit == '0') {
                currentNode = currentNode.left;
            }
            // Если бит равен '1', переходим к правому потомку
            else if (bit == '1') {
                currentNode = currentNode.right;
            }

            // Если достигнут листовой узел, добавляем символ в раскодированный текст
            if (currentNode.isLeafNode()) {
                decodedText.append(currentNode.character);
                // Возвращаемся к корню для поиска следующего символа
                currentNode = root;
            }
        }
        return decodedText.toString();
    }

    public static void main(String[] args) {
        String text = "hello world";

        // Шаг 5: Построение таблицы кодирования Хаффмана
        Map<Character, String> huffmanCodes = buildHuffmanCodes(text);

        // Вывод таблицы кодирования Хаффмана
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Шаг 6: Кодирование текста
        String encodedText = encode(text, huffmanCodes);
        System.out.println("Encoded Text: " + encodedText);

        // Шаг 7: Декодирование текста - какая-то ошибка(нужно проверить)
//        String decodedText = decode(encodedText, huffmanCodes);
//        System.out.println("Decoded Text: " + decodedText);
    }
}