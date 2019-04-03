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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root != null) helper(root, 0);
        return sum;
    }

    private void helper(TreeNode node, int base) {
        node.val += base * 10;
        if (node.left != null) helper(node.left, node.val);
        if (node.right != null) helper(node.right, node.val);
        if (node.left == null && node.right == null) sum += node.val;
    }
}