/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        // Empty list has nothing to copy.
        if (head == null) {
            return null;
        }

        // Maps each original node to its copied node.
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Step 1: Create a new node for every original node.
        while (curr != null) {

            // Create a completely new node with the same value.
            Node copy = new Node(curr.val);

            // Remember which copied node belongs to this original node.
            map.put(curr, copy);

            curr = curr.next;
        }

        // Start again from the original head.
        curr = head;

        // Step 2: Connect next and random pointers of copied nodes.
        while (curr != null) {

            // Get the copied version of the current original node.
            Node copy = map.get(curr);

            // Connect copy.next to the copied version of curr.next.
            copy.next = map.get(curr.next);

            // Connect copy.random to the copied version of curr.random.
            copy.random = map.get(curr.random);

            curr = curr.next;
        }

        // Return the copied version of the original head.
        return map.get(head);
    }
}
