/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        else return reverse(root, root.left, root.right);
    }

    private TreeNode reverse(TreeNode node, TreeNode left, TreeNode right) {
        if (left == null) return node;
        node.left = node.right = null;
        TreeNode root = reverse(left, left.left, left.right);
        if (right != null) reverse(right, right.left, right.right);
        left.right = node;
        left.left = right;
        return root;
    }
}