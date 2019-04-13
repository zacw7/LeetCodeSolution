/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        Queue<Node> queue = new LinkedList();
        inorder(root, queue);
        Node head = new Node();
        if (queue.isEmpty()) return null;
        Node prev = queue.poll(), node = prev;
        head.right = prev;
        while (!queue.isEmpty()) {
            node = queue.poll();
            prev.right = node;
            node.left = prev;
            prev = node;
        }
        node.right = head.right;
        head.right.left = node;
        return head.right;
    }

    private void inorder(Node node, Queue<Node> queue) {
        if (node == null) return;
        inorder(node.left, queue);
        queue.offer(node);
        inorder(node.right, queue);
    }
}