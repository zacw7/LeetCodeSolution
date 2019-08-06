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
    private int leftCount, rightCount;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null || n == 0) {
            return false;
        }
        leftCount = rightCount = 0;
        countNodes(root, x);
        if (root.val != x && (n - leftCount - rightCount - 1) > (leftCount + rightCount + 1)) {
            return true;
        }
        return leftCount > (n - leftCount) || rightCount > (n - rightCount);
    }

    private int countNodes(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int left = countNodes(node.left, x);
        int right = countNodes(node.right, x);
        if (node.val == x) {
            leftCount = left;
            rightCount = right;
        }
        return left + right + 1;
    }
}