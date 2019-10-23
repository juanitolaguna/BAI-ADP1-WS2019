package adp1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Comment: ...
 */

public class DoubleLinkedList<Item> implements DoubleLinkedListInterface<Item>, Iterable {
    private Node<Item> first; // enthält objekt, next, prev
    private Node<Item> last; // enthält objekt, next, prev
    private int size = 0;

    public DoubleLinkedList() {
        this.first = new Node<Item>(null, null, null);
        this.last = new Node<Item>(null, first, null);
        first.next = last;
    }

    // API

    @Override
    public void addFirst(Item element) {
        // First und Last bleibt null
        Node<Item> node = new Node<>(element);
        first.next.prev = node;
        node.next = first.next;
        first.next = node;
        node.prev = first;
        size++;

    }

    @Override
    public void addAt(Item item, int position) throws IndexOutOfBoundsException {
        if (position > size || position < 0)
            throw new IndexOutOfBoundsException();

        if (position <= size / 2.0) {
            Node<Item> current = first;
            for (int i = 0; i <= position; i++) {
                current = current.next;
            }
            // insert between current.prev & current
            Node<Item> newNode = new Node<>(item, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
        } else {
            Node<Item> current = last;
            for (int i = size - 1; i > position; i--) {
                current = current.prev;
            }
            Node<Item> newNode = new Node<>(item, current.prev, current);
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public void deleteFirst() throws EmptyListException {
        first.next = first.next.next;
        first.next.prev = first;
        size--;
    }

    // ToDo: Methode testen.
    @Override
    public void deleteLast() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException("List is Empty, cannot execute delete()");
        this.last = this.last.prev;
        this.last.next = last;
        size--;
    }

    @Override
    public void deleteAt(int position) throws IndexOutOfBoundsException {
        if (position >= size || position < 0)
            throw new IndexOutOfBoundsException();
        Node<Item> current;
        if (position <= size / 2.0) {
            current = first;
            for (int i = 0; i <= position; i++) {
                current = current.next;
            }
        } else {
            current = last;

            for (int i = size; i > position; i--) {
                current = current.prev;
            }
        }
        current.next.prev = current.prev;
        current.prev.next = current.next;
        size--;
    }

    @Override
    public void deleteElem(Object elem) throws NoSuchElementException {
        for (Node<Item> current = first.next; current != last; current = current.next) {
            if (current.element.equals(elem)) {
                current.next.prev = current.prev;
                current.prev.next = current.next;
                size--;
            }
        }
    }

    @Override
    public boolean hasSuchElement(Object elem) throws NoSuchElementException {
        boolean isPresent = false;
        for (Object node : this) {
            if (node == elem) {
                isPresent = true;
            }
        }
        return isPresent;
    }

    @Override
    public Item getValueAt(int position) throws IndexOutOfBoundsException {
        if (position >= size || position < 0)
            throw new IndexOutOfBoundsException();
        Node<Item> current;
        if (position <= size / 2.0) {
            current = first;
            for (int i = 0; i <= position; i++) {
                current = current.next;
            }
        } else {
            current = last;

            for (int i = size; i > position; i--) {
                // System.out.println("2te Hälfte " + i);
                current = current.prev;
            }
        }
        return current.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first.next == last;
    }

    @Override
    public String toString() {
        Node<Item> node = first;
        StringBuilder str = new StringBuilder();

        for (Object item : this) {
            str.append(item + " ");
        }
        return str.toString();
    }

    // internal data organization

    private static class Node<T> {
        private T element;
        private Node prev;
        private Node next;

        private Node() {
        }

        private Node(T data) {
            this.element = data;
        }

        private Node(T data, Node<T> prev, Node<T> next) {
            this.element = data;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new DllIterator();
    }

    private class DllIterator implements Iterator<Item> {
        private Node<Item> current = first.next;

        @Override
        public boolean hasNext() {
            return current != last;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item value = current.element;
            current = current.next;
            return value;
        }

    }

    public boolean equals(Object o) {
        DoubleLinkedList list = (DoubleLinkedList) o;
        boolean isEqual = true;
        isEqual = this.size() == list.size();
        if(isEqual){
            for (int i = 0; i < this.size ; i++) {
                if(!this.getValueAt(i).equals(list.getValueAt(i))){
                    return isEqual = false;
                }
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first);
    }

    /**
     * Run with gradle:
     * ./gradlew clean run
     * @param args
     * @throws EmptyListException
     * @throws NoSuchElementException
     */
    public static void main(String[] args) throws EmptyListException, NoSuchElementException {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        String[] strings = { "aa", "bb", "cc", "dd" };
        for (int i = 0; i < strings.length; i++) {
            list.addFirst(strings[i]);
        }

        System.out.println(list);
        list.addAt("ee", 3);
        System.out.println(list);
        list.addAt("ff", 1);
        System.out.println(list);
        System.out.println("Size: " + list.size());

        list.deleteAt(0);
        System.out.println(list);

        list.addAt("gg", 0);
        System.out.println(list);

        list.addAt("hh", 0);
        list.addAt("hh", 0);
        System.out.println(list);
        
        list.deleteElem("hh");
        System.out.println(list);

        list.deleteFirst();
        System.out.println(list);
        
        list.deleteLast();
        System.out.println(list);

        System.err.println(list.hasSuchElement("bb"));
        System.err.println(list.hasSuchElement(1));

        System.out.println(list.getValueAt(0));
        System.out.println(list.getValueAt(3));

        System.out.println(list.isEmpty());
        DoubleLinkedList<String> emptyList = new DoubleLinkedList<>();
        System.out.println(emptyList.isEmpty());
    }

}
