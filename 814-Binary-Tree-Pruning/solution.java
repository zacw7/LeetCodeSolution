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
    public TreeNode pruneTree(TreeNode root) {
        if (root != null && pruneHelper(root)) return null;
        return root;
    }

    public boolean pruneHelper(TreeNode node) {
        boolean res = (node.val == 0);
        if (node.left != null) {
            boolean canPrune = pruneHelper(node.left);
            if (canPrune) node.left = null;
            res = res && canPrune;
        }
        if (node.right != null) {
            boolean canPrune = pruneHelper(node.right);
            if (canPrune) node.right = null;
            res = res && canPrune;
        }
        return res;
    }
}