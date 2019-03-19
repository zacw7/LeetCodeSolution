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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        else helper(root);
        Queue<TreeNode> nodeQueue = new LinkedList();
        nodeQueue.add(root);
        int max = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node.val > max) max = node.val;
            if (node.left != null) nodeQueue.add(node.left);
            if (node.right != null) nodeQueue.add(node.right);
        }
        return max - 1;
    }

    private int helper(TreeNode node) {
        int leftLen = 0, rightLen = 0;
        if (node.left != null) leftLen = helper(node.left);
        if (node.right != null) rightLen = helper(node.right);
        node.val = leftLen + rightLen + 1;
        return Math.max(leftLen, rightLen) + 1;
    }
}