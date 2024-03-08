package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAtEnd(1);
        linkedList.addAtEnd(2);
        linkedList.addAtEnd(3);
        linkedList.addAtEnd(4);
        linkedList.addAtEnd(5);

        System.out.println("Original list:");
        linkedList.printLinkedList(linkedList.getHead());

        linkedList.invert();

        System.out.println("\nInverted list:");
        linkedList.printLinkedList(linkedList.getHead());
    }
}