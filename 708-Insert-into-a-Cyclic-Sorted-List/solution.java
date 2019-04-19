/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node insertNode = new Node(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }

        Node node = head;
        while (node.next != head) {
            if (node.val <= insertVal && node.next.val >= insertVal) {
                break;
            }
            if (node.next.val < node.val
                    && (insertVal >= node.val || insertVal <= node.next.val)) {
                break;
            }
            node = node.next;
        }

        insertNode.next = node.next;
        node.next = insertNode;

        return head;
    }
}