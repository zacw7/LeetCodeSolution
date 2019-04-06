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
    Map<TreeNode, Integer> memo = new HashMap();
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int maxSub = Integer.MIN_VALUE;
        if (root.left != null) maxSub = Math.max(maxSub, maxPathSum(root.left));
        if (root.right != null) maxSub = Math.max(maxSub, maxPathSum(root.right));
        int maxWith2Sub = root.val + maxPathSumFrom(root.left) + maxPathSumFrom(root.right);
        return Math.max(maxSub, maxWith2Sub);
    }

    private int maxPathSumFrom(TreeNode root) {
        if (root == null) return 0;
        if (!memo.containsKey(root))
            memo.put(root, Math.max(0, root.val + Math.max(maxPathSumFrom(root.left), maxPathSumFrom(root.right))));
        return memo.get(root);
    }
}