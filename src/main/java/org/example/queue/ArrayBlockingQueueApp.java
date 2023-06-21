package org.example.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueApp {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Производитель
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i); // блокируется, если очередь полностью заполнена
                    System.out.println("Произведен элемент: " + i);
                }
            } catch (InterruptedException e) {
//                System.out.println("Producer is blocked, queue is full");
                Thread.currentThread().interrupt();
            }
        }).start();

        // Потребитель
        new Thread(() -> {
            try {
                while (true) {
                    int element = queue.take(); // блокируется, если очередь пуста
                    System.out.println("Получен элемент: " + element);
                }
            } catch (InterruptedException e) {
//                System.out.println("Consumer is blocked, queue is empty");
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}

