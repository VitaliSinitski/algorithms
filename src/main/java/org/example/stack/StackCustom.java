package org.example.stack;

public interface StackCustom<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
