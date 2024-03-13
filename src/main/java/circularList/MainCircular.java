package circularList;

public class MainCircular {
    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        // Add elements
        list.addFirst("Apple");
        list.addLast("Banana");
        list.add("Cherry", 1);
        list.addLast("Dragonfruit");
        System.out.println("List: ");
        list.printLinkedList();  // Output: List: Apple Cherry Banana Dragonfruit

        // Access elements
        String firstElement = list.getValue(0);
        System.out.println("First element: " + firstElement);  // Output: First element: Apple
        String elementAtPosition2 = list.getValue(2);
        System.out.println("Element at position 2: " + elementAtPosition2);  // Output: Element at position 2: Banana

        // Remove elements
        list.remove("Banana");
        System.out.println("After removing 'Banana':");
        list.printLinkedList();  // Output: After removing 'Banana': Apple Cherry Dragonfruit

        // Sort the list
        list.sort();
        System.out.println("Sorted list:");
        list.printLinkedList();  // Output: Sorted list: Apple Cherry Dragonfruit

        // Test iterator
        System.out.println("Iterating using iterator:");
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();  // Output: Iterating using iterator: Apple Cherry Dragonfruit

        // More operations
        list.removeFirst();
        System.out.println("After removing first element:");
        list.printLinkedList();  // Output: After removing first element: Cherry Dragonfruit

        list.setValue(1, "Mango");
        System.out.println("After modifying element at position 1:");
        list.printLinkedList();  // Output: After modifying element at position 1: Cherry Mango

        list.clear();
        System.out.println("List after clear: ");
        list.printLinkedList();  // Output: List after clear:  (empty list)
    }
}
