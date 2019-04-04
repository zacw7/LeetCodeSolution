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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return Math.max(LUPFrom(root.left, root.val) + LUPFrom(root.right, root.val),
                Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
    }

    private int LUPFrom(TreeNode node, int base) {
        if (node == null || node.val != base) return 0;
        return 1 + Math.max(LUPFrom(node.left, base), LUPFrom(node.right, base));
    }
}