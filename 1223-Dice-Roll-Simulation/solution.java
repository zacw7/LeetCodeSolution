class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int MOD = 1_000_000_007;
        int[][][] dp = new int[n][6][16];
        for (int i = 0; i < 6; i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                int limit = rollMax[j];
                for (int k = 0; k < 6; k++) {
                    if (k != j) {
                        for (int c : dp[i - 1][k]) {
                            dp[i][j][1] += c;
                            dp[i][j][1] %= MOD;
                        }
                    } else {
                        for (int x = 2; x <= limit; x++) {
                            dp[i][j][x] = dp[i - 1][k][x - 1];
                            dp[i][j][x] %= MOD;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int[] d : dp[n - 1]) {
            for (int c : d) {
                res += c;
                res %= MOD;
            }
        }
        return res;
    }
}