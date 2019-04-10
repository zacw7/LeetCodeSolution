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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return startFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int startFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        int paths = 0;
        sum -= root.val;
        if (sum == 0) paths = 1;
        paths += startFrom(root.left, sum);
        paths += startFrom(root.right, sum);
        return paths;
    }
}