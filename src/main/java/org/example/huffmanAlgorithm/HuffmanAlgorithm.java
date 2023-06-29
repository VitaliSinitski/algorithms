package org.example.huffmanAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class HuffmanAlgorithm {

    // считаем частоты символов в заданном тексте и возвращаем отсортированную по ключам карту (TreeMap),
    // где каждому символу соответствует его частота в тексте.
    public static TreeMap<Character, Integer> countFrequency(String text) {
        // создание пустой карты freqMap, где ключами будут символы, а значениями - количество повторений
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        // итерация по каждому символу в заданном тексте
        for (int i = 0; i < text.length(); i++) {
            // получение текущего символа 'c' из текста
            Character c = text.charAt(i);
            // получение текущей частоты символа 'c' из карты freqMap
            Integer count = freqMap.get(c);
            // обновление карты freqMap путем добавления символа 'c' и его новой частоты
            // если символ 'c' уже присутствует в карте, увеличиваем его частоту на 1, иначе устанавливаем частоту равной 1
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }

    // реализация алгоритма Хаффмана
    public static CodeTreeNode huffman(ArrayList<CodeTreeNode> codeTreeNodes) {
        // пока в списке узлов больше, чем один
        while (codeTreeNodes.size() > 1) {
            // упорядочиваем узлы по весам
            Collections.sort(codeTreeNodes);
            // берем 2 узла с самыми маленькими весами
            // это будет 2 узла, которые мы свяжем промежуточным узлом
            // для промежуточного узла один из них будет левым потомком, а второй - правым
            // получаю из списка узел и сразу же его удаляем
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            // создаем промежуточный узел
            // в нем символа никого не будет, вес его равен сумме весов его потомков
            CodeTreeNode parent = new CodeTreeNode(null, right.weight + left.weight, left, right);
            codeTreeNodes.add(parent);
        }
        // прокручиваем это алгоритм, пока не останется всего один узел
        // этот узел и будет корнем этого кодового дерева
        return codeTreeNodes.get(0);
    }

    // decode
    // процедура обратного раскодирования:
    // если у нас есть кодовое дереве, то мы берем по одному биту из последовательности (из строки StringBuilder)
    // и начиная от корневого узла начинаем проход по дереву:
    // если стоит символ '1' то сворачиваем направо, если '0', то налево
    // каждый раз, когда мы доходим до листа, мы записываем в раскодированную строку символ, который находится в этом листе
    // в качестве параметров мы передаем строку с битами и кодовое дерево
    public static String huffmanDecode(String encoded, CodeTreeNode tree) {
        // в StringBuilder будем накапливать расшифрованные данные
        StringBuilder decoded = new StringBuilder();

        // создадим переменную, в которую мы будем хранить текущий вызов, когда будем спускаться по дереву
        // изначально он равен корневому узлу
        CodeTreeNode node = tree;
        // теперь идем по битам зашифрованный строки
        // то есть мы в цикле постоянно спускаемся от корня до листа
        // потом записываем лист в зашифрованную последовательность и снова возвращаемся в корень и снова спускаемся
        for (int i = 0; i < encoded.length(); i++) {
            // если текущий бит '0', тогда идем налево, иначе идем направо
            node = encoded.charAt(i) == '0' ? node.left : node.right;
            // если так оказалось, что мы дошли до какого-то листа в процессе этого (у листа есть какой-то символ)
            if (node.content != null) {
                // то в декодированную последовательность добавляем этот символ (значит мы его расшифровали)
                decoded.append(node.content);
                // и возвращаем текущий узел снова на корень дерева
                node = tree;
            }
        }
        return decoded.toString();
    }
}
