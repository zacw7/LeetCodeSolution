class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int MOD = 1000000007;
        if (m == 0 || n == 0 || N == 0) return 0;
        int[][][] dp = new int[N][m][n];
        for (int mo = 0; mo < N; mo++) {
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (r - 1 < 0) dp[mo][r][c]++;
                    if (r + 1 >= m) dp[mo][r][c]++;
                    if (c - 1 < 0) dp[mo][r][c]++;
                    if (c + 1 >= n) dp[mo][r][c]++;
                    if (mo > 0) {
                        if (r - 1 >= 0) dp[mo][r][c] += dp[mo - 1][r - 1][c];
                        if (dp[mo][r][c] >= MOD) dp[mo][r][c] %= MOD;
                        if (r + 1 < m) dp[mo][r][c] += dp[mo - 1][r + 1][c];
                        if (dp[mo][r][c] >= MOD) dp[mo][r][c] %= MOD;
                        if (c - 1 >= 0) dp[mo][r][c] += dp[mo - 1][r][c - 1];
                        if (dp[mo][r][c] >= MOD) dp[mo][r][c] %= MOD;
                        if (c + 1 < n) dp[mo][r][c] += dp[mo - 1][r][c + 1];
                        if (dp[mo][r][c] >= MOD) dp[mo][r][c] %= MOD;
                    }
                }
            }
        }
        return dp[N - 1][i][j];
    }
}