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
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack();
        TreeNode node = null;
        if (root != null) node = root;
        int sum = 0;
        while (node != null || !nodeStack.isEmpty()) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                node = nodeStack.pop();
                sum += node.val;
                node = node.right;
            }
        }
        if (root != null) node = root;
        while (node != null || !nodeStack.isEmpty()) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                node = nodeStack.pop();
                sum -= node.val;
                node.val += sum;
                node = node.right;
            }
        }
        return root;
    }
}