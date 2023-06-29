package org.example.huffmanCode;

// Класс, представляющий узел дерева Хаффмана
class HuffmanNode implements Comparable<HuffmanNode> {
    char character;           // Символ
    int frequency;            // Частота символа
    HuffmanNode left;         // Левый потомок
    HuffmanNode right;        // Правый потомок

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    // Метод, определяющий, является ли узел листовым
    public boolean isLeafNode() {
        return (left == null && right == null);
    }

    // Реализация метода сравнения для использования в приоритетной очереди
    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}