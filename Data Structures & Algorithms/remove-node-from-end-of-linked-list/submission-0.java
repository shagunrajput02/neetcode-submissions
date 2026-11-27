/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node helps handle deleting the head itself.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Both pointers start from the dummy node.
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n + 1 steps ahead.
        // This creates a gap so slow stops before the node to delete.
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers at the same speed.
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow.next is the node we need to remove.
        slow.next = slow.next.next;

        // Return the real head, which may have changed.
        return dummy.next;
    }
}
