package org.example.queue;

import java.util.ArrayList;

public class SimpleQueue<T> implements QueueCustom<T> {
    private ArrayList<T> list = new ArrayList<>();
    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
