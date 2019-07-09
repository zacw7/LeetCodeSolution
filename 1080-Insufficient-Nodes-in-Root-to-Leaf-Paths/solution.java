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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (isInsufficientNode(root, 0, limit)) {
            return null;
        } else {
            return root;
        }
    }

    private boolean isInsufficientNode(TreeNode node, int sum, int limit) {
        if (node == null) {
            return sum < limit;
        }

        boolean isLeftISN = isInsufficientNode(node.left, sum + node.val, limit);
        boolean isRightISN = isInsufficientNode(node.right, sum + node.val, limit);

        if (isLeftISN) {
            node.left = null;
        }
        if (isRightISN) {
            node.right = null;
        }

        return isLeftISN && isRightISN;
    }
}