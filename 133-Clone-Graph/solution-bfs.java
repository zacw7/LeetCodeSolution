/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap();
        Node head = new Node();
        head.val = node.val;
        head.neighbors = new ArrayList();
        map.put(node, head);
        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node old = queue.poll(), cur = map.get(old);
            for (Node neigh : old.neighbors) {
                if (!map.containsKey(neigh)) {
                    Node replica = new Node();
                    replica.val = neigh.val;
                    replica.neighbors = new ArrayList();
                    map.put(neigh, replica);
                    queue.offer(neigh);
                }
                cur.neighbors.add(map.get(neigh));
            }
        }
        return head;
    }
}