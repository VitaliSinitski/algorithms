package org.example.queue;

import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Добавление элементов в приоритетную очередь
        priorityQueue.offer(5);
        priorityQueue.offer(3);
        priorityQueue.offer(8);
        priorityQueue.offer(1);

        // Извлечение элементов с наивысшим приоритетом
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
