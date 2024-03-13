package list;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    //Start of the LinkedList
    Node<T> head;

    /**
     * Implementation of the iterator method
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}
