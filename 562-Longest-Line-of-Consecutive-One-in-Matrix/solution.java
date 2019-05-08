class Solution {
    // DP
    // Time: O(mn)
    // Space: O(mn)
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int R = M.length, C = M[0].length;
        int[][][] dp = new int[R][C][4];
        int maxLen = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (M[r][c] == 1) {
                    dp[r][c][0] = dp[r][c][1] = dp[r][c][2] = dp[r][c][3] = 1;
                    if (r > 0) {
                        dp[r][c][0] += dp[r - 1][c][0];
                    }
                    if (c > 0) {
                        dp[r][c][1] += dp[r][c - 1][1];
                    }
                    if (r > 0 && c > 0) {
                        dp[r][c][2] += dp[r - 1][c - 1][2];
                    }
                    if (r > 0 && c + 1 < C) {
                        dp[r][c][3] += dp[r - 1][c + 1][3];
                    }
                    maxLen = Math.max(maxLen, dp[r][c][0]);
                    maxLen = Math.max(maxLen, dp[r][c][1]);
                    maxLen = Math.max(maxLen, dp[r][c][2]);
                    maxLen = Math.max(maxLen, dp[r][c][3]);
                }
            }
        }
        return maxLen;
    }
}