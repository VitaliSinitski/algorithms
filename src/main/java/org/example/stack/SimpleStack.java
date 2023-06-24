package org.example.stack;

import java.util.ArrayList;

public class SimpleStack<T> implements StackCustom<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public void push(T item) {
        list.add(0, item);
    }

    @Override
    public T pop() {
        return list.remove(0);
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
