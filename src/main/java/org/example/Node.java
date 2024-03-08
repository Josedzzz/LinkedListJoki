package org.example;

public class Node<T> {
    T value;
    Node<T> next;

    // Constructor
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}
