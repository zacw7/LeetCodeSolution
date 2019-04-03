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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructHelper(nums, 0, nums.length - 1);
    }

    private TreeNode constructHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);
        // find the maximum
        int maxIdx = left, maxNum = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > maxNum) {
                maxIdx = i;
                maxNum = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxNum);
        node.left = constructHelper(nums, left, maxIdx - 1);
        node.right = constructHelper(nums, maxIdx + 1, right);
        return node;
    }
}