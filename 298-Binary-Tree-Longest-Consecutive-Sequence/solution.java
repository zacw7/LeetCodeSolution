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

    int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        if (root != null) {
            longestConsecutive(root, 1);
        }
        return maxLen;
    }

    private void longestConsecutive(TreeNode node, int len) {
        maxLen = Math.max(maxLen, len);
        if (node.left != null) {
            if (node.val + 1 == node.left.val) {
                longestConsecutive(node.left, len + 1);
            } else {
                longestConsecutive(node.left, 1);
            }
        }
        if (node.right != null) {
            if (node.val + 1 == node.right.val) {
                longestConsecutive(node.right, len + 1);
            } else {
                longestConsecutive(node.right, 1);
            }
        }
    }
}