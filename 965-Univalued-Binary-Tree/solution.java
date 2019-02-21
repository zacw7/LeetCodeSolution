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
    public boolean isUnivalTree(TreeNode root) {
        int univalue = root.val;
        Stack<TreeNode> nodeStack = new Stack();
        while (!nodeStack.isEmpty() || root != null) {
            if (root == null) {
                root = nodeStack.pop().right;
            } else {
                if (root.val != univalue) return false;
                nodeStack.push(root);
                root = root.left;
            }
        }
        return true;
    }
}