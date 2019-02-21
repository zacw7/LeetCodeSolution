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
        TreeNode node = root.left;
        Stack<TreeNode> nodeStack = new Stack();
        nodeStack.push(root);
        while (!nodeStack.isEmpty() || node != null) {
            if (node == null) {
                node = nodeStack.pop().right;
            } else {
                if (node.val != univalue) return false;
                nodeStack.push(node);
                node = node.left;
            }
        }
        return true;
    }
}