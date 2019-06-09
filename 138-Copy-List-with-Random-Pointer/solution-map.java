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
    // HashMap
    // TC: O(n)
    // SC: O(n)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap();
        Node oldNode = head;
        while (oldNode != null) {
            Node newNode = new Node();
            newNode.val = oldNode.val;
            map.put(oldNode, newNode);
            oldNode = oldNode.next;
        }
        oldNode = head;
        while (oldNode != null) {
            Node newNode= map.get(oldNode);
            newNode.random = map.get(oldNode.random);
            if (oldNode.next != null) {
                newNode.next = map.get(oldNode.next);
            }
            oldNode = oldNode.next;
        }
        return map.get(head);
    }
}