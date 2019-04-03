/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Node head = root;
        while (head.left != null) {
            head.left.next = head.right;
            Node prev = head, cur = head.next;
            while (cur != null) {
                prev.right.next = cur.left;
                cur.left.next = cur.right;
                prev = cur;
                cur = cur.next;
            }
            head = head.left;
        }
        return root;
    }
}