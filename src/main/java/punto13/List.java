package punto13;

public class List {
    ListNode<Integer> start;

    // Constructor
    public List() {
        start = null;
    }

    // Recursive method to find the maximum distance between subsequent occurrences of a key
    public int maxDistanceBetweenKeys(Integer key) {
        // Start the recursive search from the beginning of the list
        return maxDistanceBetweenKeysRecursive(start, key, -1, 0);
    }

    private int maxDistanceBetweenKeysRecursive(ListNode<Integer> current, Integer key, int lastPosition, int maxDistance) {
        if (current == null) {
            // Base case: end of the list
            return maxDistance;
        }

        if (current.key.equals(key)) {
            // Found the key, calculate distance
            int distance = lastPosition == -1 ? 0 : current.position - lastPosition;
            // Update max distance if needed
            maxDistance = Math.max(maxDistance, distance);
            // Recur with the current position as the last position
            return maxDistanceBetweenKeysRecursive(current.next, key, current.position, maxDistance);
        }

        // Key not found, continue searching
        return maxDistanceBetweenKeysRecursive(current.next, key, lastPosition, maxDistance);
    }


    /*
    In this code, a position variable is initialized to 1 and incremented in each iteration of the while loop. When a new node is added to the list, its position attribute is set to the current value of the position variable.
    This ensures that each node's position attribute correctly reflects its position in the list.
     */
    public void add(Integer value) {
        ListNode<Integer> newNode = new ListNode<>(value, null, 0);
        if (start == null) {
            start = newNode;
        } else {
            ListNode<Integer> current = start;
            int position = 1;
            while (current.next != null) {
                current = current.next;
                position++;
            }
            newNode.position = position;
            current.next = newNode;
        }
    }
}
