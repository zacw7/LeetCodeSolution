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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode leftmost = root.right;
                while (leftmost.left != null) {
                    leftmost = leftmost.left;
                }
                root.val = leftmost.val;
                root.right = deleteNode(root.right, root.val);
            }
            return root;
        } else {
            TreeNode parent = root;
            TreeNode node = (key < parent.val) ? parent.left : parent.right;
            while (node != null) {
                if (node.val == key) {
                    break;
                } else {
                    parent = node;
                    node = (key < parent.val) ? parent.left : parent.right;
                }
            }
            if (node != null) {
                if (node.left == null && node.right == null) {
                    if (node == parent.left) parent.left = null;
                    else if (node == parent.right) parent.right = null;
                } else if (node.left == null) {
                    if (node == parent.left) parent.left = node.right;
                    else if (node == parent.right) parent.right = node.right;
                } else if (node.right == null) {
                    if (node == parent.left) parent.left = node.left;
                    else if (node == parent.right) parent.right = node.left;
                } else {
                    TreeNode leftmost = node.right;
                    while (leftmost.left != null) {
                        leftmost = leftmost.left;
                    }
                    node.val = leftmost.val;
                    node.right = deleteNode(node.right, node.val);
                }
            }
            return root;
        }
    }
}