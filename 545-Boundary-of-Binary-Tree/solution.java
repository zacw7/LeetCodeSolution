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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                traverseLeftBoundary(root.left, res);
            }
            if (root.left != null || root.right != null) {
                traverseLeaves(root, res);
            }
            if (root.right != null) {
                traverseRightBoundary(root.right, res);
            }
        }
        return res;
    }

    private void traverseLeftBoundary(TreeNode node, List<Integer> res) {
        if (node.left != null || node.right != null) {
            res.add(node.val);
            if (node.left != null) {
                traverseLeftBoundary(node.left, res);
            } else {
                traverseLeftBoundary(node.right, res);
            }
        }
    }

    private void traverseRightBoundary(TreeNode node, List<Integer> res) {
        if (node.left != null || node.right != null) {
            if (node.right != null) {
                traverseRightBoundary(node.right, res);
            } else {
                traverseRightBoundary(node.left, res);
            }
            res.add(node.val);
        }
    }

    private void traverseLeaves(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val);
        } else {
            if (node.left != null) {
                traverseLeaves(node.left, res);
            }
            if (node.right != null) {
                traverseLeaves(node.right, res);
            }
        }
    }
}