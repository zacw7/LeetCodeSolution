class Solution {
    // DP
    // Time: O(M*N) - M, N is the length of s, p respectively
    // Space: O(M*N) - 2D array used
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        if (p.length() > 0 && p.charAt(0) == '*') {
            for (int j = 0; j <= s.length(); j++) {
                dp[1][j] = true;
            }
        }
        for (int i = 1; i <= p.length(); i++) {
            char ch_p = p.charAt(i - 1);
            if (ch_p == '*') {
                dp[i][0] = dp[i - 1][0];
            }
            for (int j = 1; j <= s.length(); j++) {
                char ch_s = s.charAt(j - 1);
                if (ch_p == '?' || ch_p == ch_s) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (ch_p == '*') {
                    if (dp[i - 1][j] == true) {
                        for (int k = j; k <= s.length(); k++) {
                            dp[i][k] = true;
                        }
                        break;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}