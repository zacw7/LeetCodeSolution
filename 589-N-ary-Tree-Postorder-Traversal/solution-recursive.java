/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> nodeValues = new ArrayList();
        if (root != null) traverse(nodeValues, root);
        return nodeValues;
    }

    private void traverse(List<Integer> nodeValues, Node node) {
        for (Node child : node.children) {
            traverse(nodeValues, child);
        }
        nodeValues.add(node.val);
    }
}