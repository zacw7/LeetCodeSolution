class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            for (int i = P; i >= 0; i--) {
                for (int j = G - g; j >= 0; j--) {
                    if (i + p >= P) {
                        dp[P][j + g] += dp[i][j];
                        dp[P][j + g] %= MOD;
                    } else {
                        dp[i + p][j + g] += dp[i][j];
                        dp[i + p][j + g] %= MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int c : dp[P]) {
            res += c;
            res %= MOD;
        }
        return res;
    }
}