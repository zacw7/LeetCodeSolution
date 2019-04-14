class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            if (i + nums[i] >= dp.length - 1) return dp[i] + 1;
            else {
                for (int j = i + nums[i]; dp[j] == 0 && j > i; j--) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}