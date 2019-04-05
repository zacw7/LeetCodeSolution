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

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;
        int leftCoins = helper(node.left);
        int rightCoins = helper(node.right);
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);
        return node.val + leftCoins + rightCoins - 1;
    }
}