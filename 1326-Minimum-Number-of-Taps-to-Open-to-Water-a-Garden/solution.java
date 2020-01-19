class Solution {
    public int minTaps(int n, int[] ranges) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[2 * n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int p = 1; p <= ranges[0] && p <= n; p++) {
            dp[2 * p - 1] = dp[2 * p] = 1;
        }

        for (int i = 1; i <= n; i++) {
            int r = ranges[i];
            if (i - r <= 0) {
                for (int p = 1; p <= i + r && p <= n; p++) {
                    dp[2 * p - 1] = dp[2 * p] = 1;
                }
            } else if (dp[i * 2 - r * 2] == Integer.MAX_VALUE) {
                continue;
            } else {
                int need = dp[i * 2 - r * 2] + 1;
                for (int p = i - r + 1; p <= i + r && p <= n; p++) {
                    dp[2 * p - 1] = Math.min(dp[2 * p - 1], need);
                    dp[2 * p] = Math.min(dp[2 * p], need);
                }
            }
        }
        if (dp[2 * n] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[2 * n];
        }
    }
}