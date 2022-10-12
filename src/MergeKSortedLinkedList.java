import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*
        Three solution
        1) Iterate over all ListNode list and add the value to Array, sort array and reconstruct LinkedList
            time O(NlogN) space O(N)
        2) Use Priority Queue, add element and reconstruct the linkedList O(kN) k is the number of linkedlist
        3) Find the min element of all the list and add it to new linkedlist O(Nlogk)

     */

    public static ListNode mergeKList(ListNode[] listNodes) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) -> a.val -b.val);

        for (ListNode l : listNodes) {
            if (l != null) {
                queue.add(l);
            }
        }

        ListNode start = new ListNode(0);
        ListNode dummy = start;

        while (!queue.isEmpty()) {
            dummy.next = queue.poll();
            dummy = dummy.next;
            if (dummy.next != null) {
                queue.add(dummy.next);
            }
        }

        return start.next;
    }
}
