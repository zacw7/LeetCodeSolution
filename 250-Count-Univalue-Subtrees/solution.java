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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = {0};
        if (root != null) countHelper(root, root.val, count);
        return count[0];
    }

    private boolean countHelper(TreeNode node, int parent, int[] count) {
        if (node == null) {
            return true;
        }
        boolean isUnival = true;
        isUnival = countHelper(node.left, node.val, count) && isUnival;
        isUnival = countHelper(node.right, node.val, count) && isUnival;
        if (isUnival) {
            count[0]++;
        }
        if (node.val == parent) {
            return isUnival;
        } else {
            return false;
        }
    }
}