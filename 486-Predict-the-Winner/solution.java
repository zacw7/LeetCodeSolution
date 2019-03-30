class Solution {

    int sum = 0;

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) return true;
        for (int n : nums) sum += n;
        return dp(nums, 0, 0, nums.length - 1, 0);
    }

    private boolean dp(int[] nums, int cur, int start, int end, int t) {
        if (t == 0) {
            // player 1 pick
            if (start == end) {
                cur += nums[start];
                return cur >= (sum - cur);
            }
            return dp(nums, cur + nums[start], start + 1, end, 1 - t)
                    || dp(nums, cur + nums[end], start, end - 1, 1 - t);
        } else {
            // player 2 pick
            if (start == end) {
                return cur >= (sum - cur);
            }
            return dp(nums, cur, start + 1, end, 1 - t)
                    && dp(nums, cur, start, end - 1, 1 - t);
        }
    }
}