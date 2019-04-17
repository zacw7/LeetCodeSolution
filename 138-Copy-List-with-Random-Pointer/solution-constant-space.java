/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    // T: O(n) - three passes
    // S: O(1)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // copy nodes
        Node curr, copy;
        curr = head;
        while (curr != null) {
            copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // copy random pointer
        curr = head;
        while (curr != null) {
            copy = curr.next;
            if (curr.random != null) {
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            curr =curr.next;
        }
        // seperate
        Node nHead = head.next;
        curr = head;
        copy = nHead;
        while (curr != null) {
            curr.next = curr.next.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
            copy = copy.next;
        }
        return nHead;
    }
}