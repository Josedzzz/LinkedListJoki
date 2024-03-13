package circularList;

import simpleList.Node;

public class CircularNode<T> {
    T value;
    CircularNode<T> next;

    // Constructor
    public CircularNode(T value) {
        this.value = value;
        this.next = null;
    }
}
