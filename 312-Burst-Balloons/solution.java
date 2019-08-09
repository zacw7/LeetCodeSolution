class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        // dp[i][j]: the max coins we can get from index i to j
        // assume k is the last balloon to burst between i and j
        // then the coins number is: c(i, j, k) = nums[i - 1] * nums[j + 1] * nums[k] + dp[i][k - 1] + dp[k + 1][j]
        // we need to find a k to maximun the c(i, j, k):
        // dp[i][j] = max{c(i, j , k)}

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = nums[i];
            if (i > 0) {
                dp[i][i] *= nums[i - 1];
            }
            if (i + 1 < N) {
                dp[i][i] *= nums[i + 1];
            }
        }

        for (int span = 1; span < N; span++) {
            for (int i = 0; i + span < N; i++) {
                int j = i + span;
                for (int k = i; k <= j; k++) {
                    int cur = nums[k];
                    if (i > 0) {
                        cur *= nums[i - 1];
                    }
                    if (j + 1 < N) {
                        cur *= nums[j + 1];
                    }
                    if (k > 0) {
                        cur += dp[i][k - 1];
                    }
                    if (k + 1 < N) {
                        cur += dp[k + 1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j], cur);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}