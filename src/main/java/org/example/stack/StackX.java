package org.example.stack;

public class StackX {
    private int maxSize;    // Размер массива
    private char[] stackArray;
    private int top;    // Вершина стека

    public StackX(int s) {  // Конструктор
        maxSize = s; // Определение размера стека
        stackArray = new char[maxSize]; // Создание массива
        top = -1; // Пока нет ни одного элемента
    }

    public void push(char j) {  // Размещение элемента на вершине стека
        stackArray[++top] = j; // Увеличение top, вставка элемента
    }

    public char pop() {         // Извлечение элемента с вершины стека
        return stackArray[top--]; // Извлечение элемента, уменьшение top
    }

    public long peek() {        // Чтение элемента с вершины стека
        return stackArray[top];
    }

    public boolean isEmpty() {  // True, если стек пуст
        return (top == -1);
    }

    public boolean isFull() {   // True, если стек полон
        return (top == maxSize - 1);
    }
}