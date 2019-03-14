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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        while (root != null && (root.val > R || root.val < L)) {
            if (root.val > R) root = root.left;
            if (root.val < L) root = root.right;
        }

        if (root == null) return root;
        TreeNode pre = root, node = pre.left;
        // trim left subtree
        while (node != null) {
            if (node.val < L) {
                do {
                    node = node.right;
                } while (node != null && node.val < L);
                pre.left = node;
            } else {
                pre = node;
                node = node.left;
            }
        }
        pre = root;
        node = pre.right;
        // trim right subtree
        while (node != null) {
            if (node.val > R) {
                do {
                    node = node.left;
                } while (node != null && node.val > R);
                pre.right = node;
            } else {
                pre = node;
                node = node.right;
            }
        }
        return root;
    }
}