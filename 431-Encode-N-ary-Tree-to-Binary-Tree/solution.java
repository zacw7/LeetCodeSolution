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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode bNode = new TreeNode(root.val);
        if (!root.children.isEmpty()) {
            bNode.left = encode(root.children.get(0));
            TreeNode child = bNode.left;
            for (int i = 1; i < root.children.size(); i++) {
                child.right = encode(root.children.get(i));
                child = child.right;
            }
        }
        return bNode;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node nNode = new Node(root.val, new ArrayList());
        TreeNode child = root.left;
        while (child != null) {
            nNode.children.add(decode(child));
            child = child.right;
        }
        return nNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));