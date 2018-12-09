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
        Stack<Node> parents = new Stack();

        Node node = head;
        while (node != null) {
            if (node.next == null && !parents.isEmpty()) {
                Node parent = parents.pop();
                node.next = parent.next;
                if (node.next != null) node.next.prev = node;
                parent.child.prev = parent;
                parent.next = parent.child;
                parent.child = null;
            }
            if (node.child != null) {
                parents.push(node);
                node = node.child;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}