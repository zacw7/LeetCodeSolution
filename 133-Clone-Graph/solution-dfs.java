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
    // dfs
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap();
        return cloneNode(node, nodeMap);
    }

    private Node cloneNode(Node node, Map<Node, Node> nodeMap) {
        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList());
        nodeMap.put(node, newNode);
        for (Node neigh : node.neighbors) {
            newNode.neighbors.add(cloneNode(neigh, nodeMap));
        }
        return newNode;
    }
}