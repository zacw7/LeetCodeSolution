class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i][j] = max{nums[k] * nums[i - 1] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]} i <= k <= j
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = (i == 0) ? 1 : nums[i - 1];
            int right = (i == nums.length - 1) ? 1 : nums[i + 1];
            dp[i][i] = left * nums[i] * right;
        }

        for (int d = 1; d < nums.length; d++) {
            for (int i = 0; i + d < nums.length; i++) {
                int j = i + d;
                int left = (i == 0) ? 1 : nums[i - 1];
                int right = (j == nums.length - 1) ? 1 : nums[j + 1];
                for (int k = i; k <= j; k++) {
                    int cur = nums[k] * left * right;
                    if (k > i) {
                        cur += dp[i][k - 1];
                    }
                    if (k < j) {
                        cur += dp[k + 1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], cur);
                }
            }
        }

        return dp[0][nums.length - 1];
    }
}