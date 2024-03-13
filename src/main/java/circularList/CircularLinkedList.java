package circularList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private CircularNode<T> head;
    private int size;

    /**
     * Constructor
     */
    public CircularLinkedList() {
        this.head = null;
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
        CircularNode<T> newNode = new CircularNode<>(value);
        if (isEmpty()) {
            newNode.next = newNode;
            head = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
        }
        size++;
    }

    /**
     * Add an element at the end of the list
     * @param value
     */
    public void addLast(T value) {
        addFirst(value);
        head = head.next;
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
            return;
        }
        if (position == size) {
            addLast(value);
            return;
        }
        CircularNode<T> newNode = new CircularNode<>(value);
        CircularNode<T> current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    /**
     * Gets a node in a specific position
     * @param position
     * @return
     */
    public CircularNode<T> getNode(int position) {
        if (!isValidIndex(position)) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        CircularNode<T> current = head.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Gets the value of a node in a specific position
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
        int position = 0;
        CircularNode<T> current = head.next;
        while (current != head) {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1; // Indicates that the value was not found
    }

    /**
     * Remove the first node of the list
     */
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        head.next = head.next.next;
        size--;
    }

    /**
     * Removes the las node of the list
     */
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        CircularNode<T> current = head.next;
        while (current.next != head) {
            current = current.next;
        }
        current.next = head.next;
        head = current;
        size--;
    }

    /**
     * Remove a node with a specific value
     * @param value
     */
    public void remove(T value) {
        if (isEmpty()) {
            throw new NoSuchElementException("Value not found");
        }
        CircularNode<T> current = head.next;
        CircularNode<T> previous = head;
        while (current != head) {
            if (current.value.equals(value)) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
        throw new NoSuchElementException("Value not found");
    }

    /**
     * Remove the node in a certain position
     * @param index
     */
    public void removeAt(int index) {
        CircularNode<T> node = getNode(index);
        remove(node.value);
    }

    /**
     * Modify the value of the node that are located in the position
     * @param position
     * @param newValue
     */
    public void setValue(int position, T newValue) {
        CircularNode<T> node = getNode(position);
        node.value = newValue;
    }

    /**
     * Sort a circularLinkedList
     */
    public void sort() {
        if (isEmpty() || size == 1) {
            return; // List is already sorted or empty
        }
        for (int i = 0; i < size - 1; i++) {
            CircularNode<T> current = head.next;
            for (int j = 0; j < size - 1 - i; j++) {
                if (current.value.compareTo(current.next.value) > 0) {
                    T temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                }
                current = current.next;
            }
        }
    }

    /**
     * Print the list
     */
    public void printLinkedList() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        CircularNode<T> current = head.next;
        do {
            System.out.print(current.value + " ");
            current = current.next;
        } while (current != head.next);
        System.out.println();
    }

    /**
     * Removes the lisr
     */
    public void clear() {
        head.next = null;
        size = 0;
    }

    /**
     * Checks if an index is valid
     * @param index
     * @return
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Iterator for the circularLinkedList
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private CircularNode<T> current = head.next;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                count++;
                return value;
            }
        };
    }

    //SOLUTION FOR LABORATORY -------------------------------------------------------------------------------------

    //9. Write the insert and search method

    /**
     * Search an element with a certain value
     * @param value
     * @return
     */
    public int search(T value) {
        if (isEmpty()) {
            return -1; // List is empty
        }
        CircularNode<T> current = head.next;
        int position = 0;
        do {
            if (current.value.equals(value)) {
                return position;
            }
            current = current.next;
            position++;
        } while (current != head.next);
        return -1; // Value not found
    }

    /**
     * Insert a value on a certain position
     * @param value
     * @param position
     */
    public void insert(T value, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Invalid position: cannot insert before the beginning");
        }
        if (isEmpty()) {
            addFirst(value);
            return;
        }
        if (position == 0) {
            addFirst(value);
            return;
        }
        if (position >= size) {
            addLast(value);
            return;
        }
        CircularNode<T> newNode = new CircularNode<>(value);
        CircularNode<T> current = head.next;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
}
