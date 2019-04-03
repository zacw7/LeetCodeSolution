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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        while (node != null) {
            if (val < node.val) {
                if (node.left == null) node.left = new TreeNode(val);
                node = node.left;
            } else if (val > node.val) {
                if (node.right == null) node.right = new TreeNode(val);
                node = node.right;
            } else {
                break;
            }
        }
        return root;
    }
}