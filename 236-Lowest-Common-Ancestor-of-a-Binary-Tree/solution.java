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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode node = root;
        boolean inLeft = findInSub(node.left, p, q);
        boolean inRight = findInSub(node.right, p, q);
        while (node != null && !(inLeft && inRight)) {
            if (inLeft) node = node.left;
            else if (inRight) node = node.right;
            else return null;
            if ((inLeft && inRight) || node == p || node == q) break;
            inLeft = findInSub(node.left, p, q);
            inRight = findInSub(node.right, p, q);
        }
        return node;
    }

    private boolean findInSub(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        if (node == p || node == q) return true;
        return findInSub(node.left, p, q) || findInSub(node.right, p, q);
    }
}