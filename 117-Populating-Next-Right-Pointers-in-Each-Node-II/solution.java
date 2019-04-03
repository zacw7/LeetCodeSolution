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
        Node head = root, nextHead = null, cur = null;
        while (head != null || nextHead != null) {
            if (head == null) {
                head = nextHead;
                nextHead = null;
            }
            if (head.left != null) {
                if (nextHead == null) {
                    nextHead = head.left;
                    cur = nextHead;
                } else {
                    cur.next = head.left;
                    cur = cur.next;
                }
            }
            if (head.right != null) {
                if (nextHead == null) {
                    nextHead = head.right;
                    cur = nextHead;
                } else {
                    cur.next = head.right;
                    cur = cur.next;
                }
            }
            head = head.next;
        }
        return root;
    }
}