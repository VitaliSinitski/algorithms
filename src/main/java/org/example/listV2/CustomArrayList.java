package org.example.listV2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * CustomArrayList represents a custom implementation of an ArrayList.
 *
 * @param <E> the type of elements stored in the list
 * @author Vitali
 */
public class CustomArrayList<E> implements CustomList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;
    private int size;

    /**
     * Constructs a CustomArrayList with the default initial capacity.
     */
    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a CustomArrayList with the specified initial capacity.
     *
     * @param initSize the initial capacity of the CustomArrayList
     * @throws IllegalArgumentException if the initial capacity is negative
     */
    public CustomArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("Illegal size for CustomArrayList: " + initSize);
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
     * Ensures that the internal array has enough capacity to accommodate the specified number of elements.
     *
     * @param needCapacity the required capacity for the array
     */
    private void ensureCapacity(int needCapacity) {
        if (needCapacity > elements.length) {
            Object[] oldElements = this.elements;
            int newSize = this.size * 2 + 1;
            this.elements = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    /**
     * Checks if the provided index is within the valid range for the current list size.
     *
     * @param index the index to be checked
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added
     * @return true
     */
    @Override
    public boolean add(E element) {
        ensureCapacity(this.size + 1);
        elements[this.size++] = element;
        return true;
    }

    /**
     * Adds the specified element at the specified index.
     *
     * @param index   the index at which the element should be added
     * @param element the element to be added
     * @return true if the element is successfully added
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean add(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        System.arraycopy(this.elements, index, elements, index + 1, size - index);
        elements[index] = element;
        this.size++;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from the list, if present.
     *
     * @param element the element to be removed
     */
    @Override
    public void remove(E element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) {
                    fastRemove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    fastRemove(i);
                    return;
                }
            }
        }
    }

    /**
     * Removes the element at the specified index from the list.
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void fastRemove(int index) {
        checkRange(index);
        int movedNumber = this.size - index - 1;
        if (movedNumber > 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, movedNumber);
        }
        this.elements[--this.size] = null;
    }

    /**
     * Retrieves the element at the specified index from the list.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.
     *
     * @param element the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index   the index of the element to be replaced
     * @param element the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void set(int index, E element) {
        checkRange(index);
        elements[index] = element;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param element the element to be checked
     * @return true if the element is found in the list, false otherwise
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    /**
     * Removes all elements from the list.
     */
    @Override
    public void clear() {
        Arrays.fill(this.elements, null);
        this.size = 0;
    }

    /**
     * Returns an array containing all elements in the list.
     *
     * @return an array containing all elements in the list
     */
    @Override
    public E[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return an iterator over the elements in the list
     */
    @Override
    public Iterator<E> iterator() {
        return new CustomIterator<>();
    }

    /**
     * Returns a string representation of the CustomArrayList.
     *
     * @return a string representation of the CustomArrayList
     */
    @Override
    public String toString() {
        return "CustomArrayList{" +
               "elements=" + Arrays.toString(elements) +
               ", size=" + size +
               '}';
    }

    private class CustomIterator<T> implements Iterator<T> {
        private int current = 0;

        /**
         * Checks if there are more elements in the iteration.
         *
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return current < size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element
         */
        @Override
        public T next() {
            T value = (T) elements[current++];
            return value;
        }
    }
}
