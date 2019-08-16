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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode target = findNode(root, x);
        int left = countNodes(target.left);
        int right = countNodes(target.right);
        int parent = (root == target) ? 0 : n - left - right - 1;
        return n < 2 * left || n < 2 * right || n < 2 * parent;
    }

    private TreeNode findNode(TreeNode node, int val) {
        if (node == null) {
            return null;
        } else if (node.val == val) {
            return node;
        } else {
            TreeNode left = findNode(node.left, val);
            if (left != null) {
                return left;
            }
            TreeNode right = findNode(node.right, val);
            if (right != null) {
                return right;
            }
        }
        return null;
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countNodes(node.left) + countNodes(node.right);
        }
    }
}