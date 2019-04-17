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
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int closest = 0;
        while (root != null) {
            double curr = Math.abs((double) (root.val - target));
            if (curr < diff) {
                diff = curr;
                closest = root.val;
            }
            if (target == closest) {
                return root.val;
            } else if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}