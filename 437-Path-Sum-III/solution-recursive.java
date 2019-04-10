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
    public int pathSum(TreeNode root, int sum) {
        if (root != null) startFrom(root, sum);
        return ans;
    }

    private void startFrom(TreeNode root, int target) {
        helper(root, target);
        if (root.left != null) startFrom(root.left, target);
        if (root.right != null) startFrom(root.right, target);
    }

    private void helper(TreeNode node, int target) {
        if (node == null) return;
        if (node.val == target) ans++;
        if (node.left != null) helper(node.left, target - node.val);
        if (node.right != null) helper(node.right, target - node.val);
    }
}