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
        int lo = Math.min(p.val, q.val), hi = Math.max(p.val, q.val);
        while (root != null && (root.val < lo || root.val > hi)) {
            if (root.val < lo) root = root.right;
            else if (root.val > hi) root = root.left;
        }
        return root;
    }
}