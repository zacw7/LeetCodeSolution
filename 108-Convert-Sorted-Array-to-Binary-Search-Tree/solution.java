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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = end - (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > start) node.left = helper(nums, start, mid - 1);
        if (mid < end) node.right = helper(nums, mid + 1, end);
        return node;
    }
}