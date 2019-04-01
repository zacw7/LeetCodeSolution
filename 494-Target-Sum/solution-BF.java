class Solution {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dp(nums, 0, 0, S);
        return count;
    }

    private void dp(int[] nums, int cur, int i, int S) {
        if (i == nums.length) {
            if (cur == S) count++;
        } else {
            dp(nums, cur + nums[i], i + 1, S);
            dp(nums, cur - nums[i], i + 1, S);
        }
    }
}