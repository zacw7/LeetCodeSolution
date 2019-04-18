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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode node = root, prev = null;
        while (node != null && node != p) {
            if (node.val > p.val) {
                prev = node;
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // find the smallest node in the right subtree
        if (node.right != null) {
            TreeNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        } else {
            return prev;
        }
    }
}