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
    public List<Integer> preorder(Node root) {
        List<Integer> nodeValues = new ArrayList();
        Stack<Node> nodeStack = new Stack();
        while(!nodeStack.isEmpty() || root != null) {
            if (root == null) {
                root = nodeStack.pop();
            } else {
                nodeValues.add(root.val);
                if (root.children != null && root.children.size() > 0) {
                    for (int i = root.children.size() - 1; i > 0; i--) {
                        nodeStack.push(root.children.get(i));
                    }
                    root = root.children.get(0);
                } else {
                    root = null;
                }
            }
        }
        return nodeValues;
    }
}