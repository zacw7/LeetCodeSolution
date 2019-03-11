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
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        if (root.left == null || root.right == null) return false;
        Stack<TreeNode> leftSubtree = new Stack(), rightSubtree = new Stack();
        leftSubtree.push(root.left);
        rightSubtree.push(root.right);
        while (!leftSubtree.isEmpty() && !rightSubtree.isEmpty()) {
            TreeNode left = leftSubtree.pop(), right = rightSubtree.pop();
            if (left.val != right.val) return false;
            if (left.left != null && right.right != null) {
                leftSubtree.push(left.left);
                rightSubtree.push(right.right);
            } else if (left.left == null && right.right == null) {
                ;
            } else {
                return false;
            }
            if (left.right != null && right.left != null) {
                leftSubtree.push(left.right);
                rightSubtree.push(right.left);
            } else if (left.right == null && right.left == null) {
                ;
            } else {
                return false;
            }
        }
        return leftSubtree.isEmpty() && rightSubtree.isEmpty();
    }
}