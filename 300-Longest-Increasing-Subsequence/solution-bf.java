class Solution {
    // TLE
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        if (nums.length != 0) helper(nums, 0, 0, Integer.MIN_VALUE);
        return max;
    }

    private void helper(int[] nums, int index, int len, int bound) {
        if (index == nums.length) max = Math.max(max, len);
        else {
            if (nums[index] > bound) {
                helper(nums, index + 1, len + 1, nums[index]);
            }
            helper(nums, index + 1, len, bound);
        }
    }
}