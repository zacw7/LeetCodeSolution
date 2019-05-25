class Solution {
    public int numTilings(int N) {
        if (N <= 2) {
            return N;
        }
        int MOD = 1000000007;
        int[][] dp = new int[2][N];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 2;
        dp[1][1] = 2;
        for (int i = 2; i < N; i++) {
            dp[0][i] = (dp[0][i - 2] + dp[0][i - 1]) % MOD + dp[1][i - 1];
            dp[1][i] = (dp[0][i - 2] * 2) % MOD + dp[1][i - 1];
            dp[0][i] %= MOD;
            dp[1][i] %= MOD;
        }
        return dp[0][N - 1];
    }
}