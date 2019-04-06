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
        if (node == null) return null;
        Map<Node, Node> map = new HashMap();
        return clone(node, map);
    }

    private Node clone(Node oNode, Map<Node, Node> map) {
        Node nNode = new Node();
        nNode.val = oNode.val;
        nNode.neighbors = new ArrayList();
        map.put(oNode, nNode);
        for (Node neighbor : oNode.neighbors) {
            if (map.containsKey(neighbor)) nNode.neighbors.add(map.get(neighbor));
            else nNode.neighbors.add(clone(neighbor, map));
        }
        return nNode;
    }
}