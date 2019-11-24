class Solution {
    public int numWays(int steps, int arrLen) {
        int N = Math.min(steps, arrLen);
        if (N == 1) {
            return 1;
        }
        int MOD = 1_000_000_007;
        int[] dp = new int[N];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < steps; i++) {
            int[] prev = dp.clone();
            dp[0] = prev[0] + prev[1];
            dp[0] %= MOD;
            dp[N - 1] = prev[N - 1] + prev[N - 2];
            dp[N - 1] %= MOD;
            for (int j = 1; j < N - 1; j++) {
                dp[j] = prev[j] + prev[j + 1] + prev[j - 1];
                dp[j] %= MOD;
            }
        }
        return dp[0];
    }
}