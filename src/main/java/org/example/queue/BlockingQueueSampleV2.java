package org.example.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueSampleV2 {
    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);


        new Thread(() -> {
            String[] words = new String[]{"123", "abc", "qwerty", "queue", "stack", "array", "list"};

            for (int i = 0; i < words.length && !Thread.interrupted(); ) {
                try {
                    Thread.sleep(1000);
                    queue.put(words[i]);
                    System.out.println("producer: записал в очередь " + words[i] + ", число элементов в очереди: " + queue.size());
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            StringBuilder sb = new StringBuilder();
            while (!Thread.interrupted()) {
                try {
                    sb.setLength(0);
                    Thread.sleep(3000);
                    sb.append(queue.take());
                    System.out.println("consumer: обработал из очереди " + sb.reverse() + ", число элементов в очереди: " + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
