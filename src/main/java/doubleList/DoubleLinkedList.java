package doubleList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    /**
     * Constructor
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element at the beginning of the list
     * @param value
     */
    public void addFirst(T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Add an element at the end of the list
     * @param value
     */
    public void addLast(T value) {
        DoubleNode<T> newNode = new DoubleNode<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    /**
     * Add an element at a specific position
     * @param value
     * @param position
     */
    public void add(T value, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (position == 0) {
            addFirst(value);
        } else if (position == size) {
            addLast(value);
        } else {
            DoubleNode<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            DoubleNode<T> newNode = new DoubleNode<>(value);
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
            size++;
        }
    }

    /**
     * Get the node at a specific position
     * @param position
     * @return
     */
    public DoubleNode<T> getNode(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        DoubleNode<T> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Get the node value at a specific position
     * @param position
     * @return
     */
    public T getValue(int position) {
        return getNode(position).value;
    }

    /**
     * Get the index of a node value
     * @param value
     * @return
     */
    public int getNodePosition(T value) {
        DoubleNode<T> current = head;
        int position = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }

    /**
     * Checl if an index is valid
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Remove the first node of the list
     */
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
    }

    /**
     * Removes the las node of the list
     */
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List becomes empty
        }
        size--;
    }

    /**
     * Remove a node with a specific value
     * @param value
     */
    public void remove(T value) {
        DoubleNode<T> current = head;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) {
            throw new NoSuchElementException("Value not found");
        }
        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
        }
    }

    /**
     * Implementation of the iterator method of the Iterable interface
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private  DoubleNode<T> current = head;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}
