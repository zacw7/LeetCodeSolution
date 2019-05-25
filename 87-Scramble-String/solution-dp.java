class Solution {
    // DP
    // TC: O(N^4)
    // SC: O(N^3)
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int LEN = s1.length();
        // dp(k, i, j) is true if s1.substring(i, i + k) is a scrambled string of s2.substring(j, i + k)
        boolean[][][] dp = new boolean[LEN + 1][LEN][LEN];
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                dp[0][i][j] = true;
            }
        }
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[1][i][j] = true;
                }
            }
        }
        for (int k = 1; k <= LEN; k++) {
            for (int i = 0; i + k <= LEN; i++) {
                for (int j = 0; j + k <= LEN; j++) {
                    for (int m = 1; m < k; m++) {
                        if ((dp[m][i][j] && dp[k - m][i + m][j + m])
                                || (dp[m][i][j + k - m] && dp[k - m][i + m][j])) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[LEN][0][0];
    }
}