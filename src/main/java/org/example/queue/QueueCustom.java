package org.example.queue;

public interface QueueCustom<T> {
    void add(T item);
    T peek();
    T remove();
    boolean isEmpty();
}
