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
        int left = 0, right = 0;
        if (root.left != null) {
            left = searchHelper(root.left, root.val, root.val < root.left.val);
        }
        if (root.right != null) {
            right = searchHelper(root.right, root.val, root.val < root.right.val);
        }
        int cur = 1;
        if (root.left == null || root.right == null
                || ((root.val > root.left.val) == (root.val < root.right.val))) {
            cur += left + right;
        } else {
            cur += Math.max(left, right);
        }
        return Math.max(cur,
                Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    private int searchHelper(TreeNode node, int parent, boolean increasing) {
        if (node == null
                || (increasing && node.val - parent != 1)
                || (!increasing && node.val - parent != -1)){
            return 0;
        }
        return 1 + Math.max(searchHelper(node.left, node.val, increasing),
                searchHelper(node.right, node.val, increasing));
    }
}