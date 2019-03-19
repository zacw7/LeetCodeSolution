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
    int ans = 0;
    public int findTilt(TreeNode root) {
        if (root != null) helper(root);
        return ans;
    }

    private int helper(TreeNode node) {
        int leftSum = 0, rightSum = 0;
        if (node.left != null) leftSum = helper(node.left);
        if (node.right != null) rightSum = helper(node.right);
        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}