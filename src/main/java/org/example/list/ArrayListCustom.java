package org.example.list;

/**
 * Custom ArrayList class.
 *
 * @author Vitali Sinitski
 * @param <T> the type of elements in the list
 */
public class ArrayListCustom<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * ArrayListCustom constructor with the default initial capacity.
     */
    public ArrayListCustom() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Returns the current size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param o the element to be searched
     * @return true if the element is found, false otherwise
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    public void add(T element) {
        if (size == elements.length) {
            expandCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Removes the element at the specified index from the list.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * Increases the capacity of the list by doubling its current capacity.
     */
    private void expandCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
