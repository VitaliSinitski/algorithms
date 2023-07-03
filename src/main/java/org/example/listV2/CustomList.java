package org.example.listV2;

/**
 * CustomList interface represents a custom list data structure.
 *
 * @author Vitali Sinitski
 * @param <E> the type of elements in the list
 */
public interface CustomList<E> extends Iterable<E> {

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    int size();

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     */
    boolean add(E element);

    /**
     * Inserts an element at the specified index in the list.
     *
     * @param index   the index at which the element should be inserted
     * @param element the element to be inserted
     * @return true if the element was successfully inserted, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    boolean add(int index, E element);

    /**
     * Removes the first occurrence of the specified element from the list.
     *
     * @param element the element to be removed
     */
    void remove(E element);

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    E get(int index);

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     *
     * @param element the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    int indexOf(E element);

    /**
     * Replaces the element at the specified index with the specified element.
     *
     * @param index   the index of the element to be replaced
     * @param element the new element to be set
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    void set(int index, E element);

    /**
     * Checks if the list contains the specified element.
     *
     * @param element the element to be searched
     * @return true if the element is found, false otherwise
     */
    boolean contains(E element);

    /**
     * Removes all elements from the list, making it empty.
     */
    void clear();

    /**
     * Returns an array containing all the elements in the list in proper sequence.
     *
     * @return an array containing all the elements in the list
     */
    E[] toArray();
}

