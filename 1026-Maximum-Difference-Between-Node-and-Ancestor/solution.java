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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxAncestorDiff(root, root.val, root.val);
    }

    private int maxAncestorDiff(TreeNode node, int max, int min) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(Math.max(Math.abs(node.val - max), Math.abs(node.val - min)),
                    Math.max(maxAncestorDiff(node.left, Math.max(max, node.val), Math.min(min, node.val)),
                            maxAncestorDiff(node.right, Math.max(max, node.val), Math.min(min, node.val))));
        }
    }
}