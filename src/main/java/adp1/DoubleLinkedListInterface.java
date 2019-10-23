package adp1;

import java.nio.file.NoSuchFileException;
import java.util.NoSuchElementException;

public interface DoubleLinkedListInterface<Item> {

    /**
     * Add element at the beginning of the list
     */
    public void addFirst(Item element);

    /**
     *
     * @param position
     * @throws IndexOutOfBoundsException
     */
    public void addAt(Item item, int position) throws IndexOutOfBoundsException; //test ok

    /**
     * Delete element at the beginning of the list
     * @throws EmptyListException
     */
    public void deleteFirst() throws EmptyListException; // test ok

    /**
     * Delete element at the end of the list
     * @throws EmptyListException
     */
    public void deleteLast() throws EmptyListException; // test ok

    /**
     * Delete element at the given position in the list.
     * @param position
     * @throws IndexOutOfBoundsException
     */
    public void deleteAt(int position) throws IndexOutOfBoundsException; // test ok

    /**
     * Delete given element.
     * @param elem
     * @throws NoSuchFileException
     */
    public void deleteElem(Item elem) throws NoSuchElementException; // test ok

    /**
     * Check if element exists.
     * @param elem
     * @return boolean
     * @throws NoSuchElementException
     */
    public boolean hasSuchElement(Item elem) throws NoSuchElementException; // test ok

    /**
     * Get element at given position.
     * @param position
     * @return Element if exists.
     * @throws IndexOutOfBoundsException
     */
    public Item getValueAt(int position) throws IndexOutOfBoundsException; // test ok

    /**
     * @return size of list.
     */
    public int size(); // test ok

    /**
     * Check if empty.
     * @return boolean
     */
    public boolean isEmpty(); // test ok

}

