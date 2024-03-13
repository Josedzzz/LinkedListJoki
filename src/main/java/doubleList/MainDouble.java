package doubleList;

public class MainDouble {

    public static void main(String[] args) {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();

        // Add elements
        list.addFirst("Apple");
        list.addLast("Banana");
        list.add("Cherry", 1);  // Insert at index 1
        list.addLast("Dragonfruit");

        // Print the list
        System.out.println("List: ");
        list.printLinkedList();

        // Access elements
        String firstElement = list.getValue(0);
        System.out.println("First element: " + firstElement);

        String elementAtPosition2 = list.getValue(2);
        System.out.println("Element at position 2: " + elementAtPosition2);

        // Remove elements
        list.remove("Banana");
        System.out.println("After removing 'Banana':");
        list.printLinkedList();

        list.removeFirst();
        System.out.println("After removing first element:");
        list.printLinkedList();

        // Sort the list
        list.sort();
        System.out.println("Sorted list:");
        list.printLinkedList();

        // Reverse the list
        list.reverse();
        System.out.println("Reversed list:");
        list.printLinkedList();

        // Check if empty
        boolean isEmpty = list.isEmpty();
        System.out.println("List is empty: " + isEmpty);

        // Clear the list
        list.clear();
        isEmpty = list.isEmpty();
        System.out.println("List after clear: " + isEmpty);
    }

}
