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
    double max = 0d;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] cur = new int[]{left[0] + right[0] + 1, left[1] + right[1] + node.val};
        max = Math.max(max, cur[1] * 1.0 / cur[0]);
        return cur;
    }
}