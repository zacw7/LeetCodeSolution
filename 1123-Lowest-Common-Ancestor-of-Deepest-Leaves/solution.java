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
    int maxDepth = 0;
    TreeNode lca = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findDepth(root, 0);
        return lca;
    }

    private int findDepth(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        } else {
            depth += 1;
        }
        int leftDepth = findDepth(node.left, depth);
        int rightDepth = findDepth(node.right, depth);
        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            lca = node;
        }
        return Math.max(leftDepth, rightDepth);
    }
}