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

    TreeNode ans = null;
    int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        findDepth(root, 0);
        return ans;
    }

    private int findDepth(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }
        int left = findDepth(node.left, depth + 1);
        int right = findDepth(node.right, depth + 1);
        if (left == maxDepth && right == maxDepth) {
            ans = node;
        }
        return Math.max(left, right);
    }
}