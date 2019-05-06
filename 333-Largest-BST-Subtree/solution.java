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

    private int max = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root != null) validateHelper(root);
        return max;
    }

    private int[] validateHelper(TreeNode node) {
        int[] left = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] right = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        if (node.left != null) {
            left = validateHelper(node.left);
        }
        if (node.right != null) {
            right = validateHelper(node.right);
        }
        if (node.val <= left[1] || node.val >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        } else {
            int cur = left[2] + right[2] + 1;
            max = Math.max(cur, max);
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), cur};
        }
    }
}