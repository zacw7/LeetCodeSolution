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
    int max = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root != null) helper(root);
        return max - 1;
    }

    private int helper(TreeNode node) {
        int leftLen = 0, rightLen = 0;
        if (node.left != null) leftLen = helper(node.left);
        if (node.right != null) rightLen = helper(node.right);
        int cur = leftLen + rightLen + 1;
        if (cur > max) max = cur;
        return Math.max(leftLen, rightLen) + 1;
    }
}