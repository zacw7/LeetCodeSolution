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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> nodeQ = new LinkedList();
        if (root != null) nodeQ.add(root);;
        List<List<Integer>> ans = new ArrayList();
        while (!nodeQ.isEmpty()) {
            List<Integer> level = new ArrayList();
            int count = nodeQ.size();
            while (count-- > 0) {
                Node node = nodeQ.poll();
                level.add((node.val));
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node n : node.children) nodeQ.add(n);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}