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
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = {0};
        searchHelper(root, 1, ans);
        return ans[0];
    }

    private void searchHelper(TreeNode node, int curLen, int[] ans) {
        ans[0] = Math.max(ans[0], curLen);
        if (node.left != null) {
            if (node.val + 1 == node.left.val) {
                searchHelper(node.left, curLen + 1, ans);
            } else {
                searchHelper(node.left, 1, ans);
            }
        }
        if (node.right != null) {
            if (node.val + 1 == node.right.val) {
                searchHelper(node.right, curLen + 1, ans);
            } else {
                searchHelper(node.right, 1, ans);
            }
        }
    }
}