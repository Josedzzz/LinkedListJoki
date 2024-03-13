package doubleList;

public class DoubleNode<T> {
    T value;
    DoubleNode<T> previous;
    DoubleNode<T> next;

    /**
     * Constructor
     * @param value
     */
    public DoubleNode(T value) {
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}
