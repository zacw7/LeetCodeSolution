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
    public boolean isBalanced(TreeNode root) {
        return heightCalc(root) != -1;
    }

    private int heightCalc(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = 0, rightHeight = 0;
        if (node.left != null) leftHeight = heightCalc(node.left);
        if (node.right != null) rightHeight = heightCalc(node.right);
        if (leftHeight == -1
                || rightHeight == -1
                || Math.abs(leftHeight - rightHeight) > 1) return -1;
        else return Math.max(leftHeight, rightHeight) + 1;
    }
}