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

    public void reorderList(ListNode head) {

        // A list with 0 or 1 node does not need reordering.
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle using slow and fast pointers.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // second points to the beginning of the second half.
        ListNode second = slow.next;

        // Break the list into two separate halves.
        slow.next = null;


        // Step 2: Reverse the second half.
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {

            // Save next node before changing curr.next.
            ListNode next = curr.next;

            // Reverse the current node's pointer.
            curr.next = prev;

            // Move prev forward.
            prev = curr;

            // Move curr forward.
            curr = next;
        }

        // prev is now the head of the reversed second half.
        second = prev;


        // Step 3: Merge both halves alternately.
        ListNode first = head;

        while (second != null) {

            // Save where both lists should continue from.
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            // Connect one node from the first half
            // to one node from the second half.
            first.next = second;

            // Connect back to the next node of the first half.
            second.next = firstNext;

            // Move both pointers forward.
            first = firstNext;
            second = secondNext;
        }
    }
}
