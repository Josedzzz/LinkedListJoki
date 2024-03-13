package list;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Test adding elements
        System.out.println("Adding elements:");
        list.addFirst(10);
        list.addLast(20);
        list.add(5, 0);
        list.printLinkedList();  // Output: 5->10->20->

        // Test size and isEmpty
        System.out.println("Size of the list: " + list.size());  // Output: 3
        System.out.println("Is the list empty? " + list.isEmpty());  // Output: false

        // Test get and set
        System.out.println("Value at index 1: " + list.getValue(1));  // Output: 10
        list.setValue(2, 15);
        System.out.println("Updated list:");
        list.printLinkedList();  // Output: 5->10->15->

        // Test remove
        System.out.println("Removing element at index 0:");
        list.removeAt(0);
        System.out.println("Updated list:");
        list.printLinkedList();  // Output: 10->15->

        // Test sort
        System.out.println("Sorting the list:");
        list.sort();
        System.out.println("Sorted list:");
        list.printLinkedList();  // Output: 10->15->

        // Test reverse
        System.out.println("Reversing the list:");
        list.reverse();
        System.out.println("Reversed list:");
        list.printLinkedList();  // Output: 15->10->

        // Test clear
        System.out.println("Clearing the list:");
        list.clear();
        System.out.println("Size of the list: " + list.size());  // Output: 0
        System.out.println("Is the list empty? " + list.isEmpty());  // Output: true

        // Test iterator
        System.out.println("Iterating over the list (should be empty):");
        list.printLinkedList();
    }
}