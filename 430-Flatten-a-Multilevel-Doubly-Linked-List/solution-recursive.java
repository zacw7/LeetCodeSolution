/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node prev = dummy, node = dummy.next;
        while (node != null) {
            if (node.child != null) {
                node.next = flatten(node.child, node.next);
                node.child = null;
                node.next.prev = node;
            }
            prev = node;
            node = node.next;
        }
        return dummy.next;
    }

    private Node flatten(Node head, Node tail) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = tail;
        if (tail != null) {
            tail.prev = node;
        }
        return head;
    }
}