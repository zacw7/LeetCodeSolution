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
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap();
        for (Node old = head, prev = null; old != null; old = old.next) {
            Node node = new Node(old.val);
            map.put(old, node);
            if (prev != null) prev.next = node;
            prev = node;
        }
        for (Node old = head, nNode = map.get(old); old != null; old = old.next, nNode = nNode.next) {
            if (old.random != null) nNode.random = map.get(old.random);
        }
        return map.get(head);
    }
}