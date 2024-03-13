package punto13;

public class ListNode<Integer> {
    Integer key;
    ListNode<Integer> next;
    Integer position;

    public ListNode(Integer k, ListNode<Integer> n, Integer position) {

        this.key = k;
        this.next = n;
        this.position = position;
    }
}
