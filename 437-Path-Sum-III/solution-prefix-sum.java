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
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSum = new HashMap();
        prefixSum.put(0, 1);
        helper(root, 0, sum, prefixSum);
        return count;
    }

    private void helper(TreeNode root, int cur, int sum, Map<Integer, Integer> prefixSum) {
        if (root == null) return;
        cur += root.val;
        count += prefixSum.getOrDefault(cur - sum, 0);
        prefixSum.put(cur, prefixSum.getOrDefault(cur, 0) + 1);
        helper(root.left, cur, sum, prefixSum);
        helper(root.right, cur, sum, prefixSum);
        prefixSum.put(cur, prefixSum.get(cur) - 1);
    }
}