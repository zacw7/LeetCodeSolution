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
    public int maxDepth(Node root) {
        int depth = 0;
        Queue<Node> nodeQueue = new LinkedList();
        if (root != null) nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeQueue.poll();
                if (node.children != null) {
                    for (Node child : node.children) nodeQueue.offer(child);
                }
            }
            depth++;
        }
        return depth;
    }
}