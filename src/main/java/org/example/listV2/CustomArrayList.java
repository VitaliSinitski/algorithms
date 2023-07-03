package org.example.listV2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Custom ArrayList class.
 *
 * @author Vitali Sinitski
 * @param <E> the type of elements in the list
 */
public class CustomArrayList<E> implements CustomList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    /**
     * ArrayListCustom constructor with the default initial capacity and without parameters.
     */
    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
        size = 0;
    }

    /**
     * ArrayListCustom constructor with initial capacity as parameter and throwing exception if param is smaller than 0.
     *
     * @param initSize the size of the CustomArrayList
     * @throws IllegalArgumentException if param is smaller than 0
     */
    public CustomArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("Size of CustomArrayList is illegal: " + initSize);
        }
        elements = (E[]) new Object[initSize];
        size = 0;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the current size of the list.
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Ensured that the size of the CustomArrayList is enough for add new Elements
     *
     * @param needCapacity the size of the needed capacity
     */
    private void ensureCapacity(int needCapacity) {
        if (needCapacity > elements.length) {
            Object[] oldElements = elements;
            int newSize = size * 2 + 1;
            elements = (E[]) new Object[newSize];
            elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    @Override
    public boolean add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        return false;
    }

    @Override
    public void remove(E element) {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
