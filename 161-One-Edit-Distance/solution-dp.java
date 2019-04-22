class Solution {
    // dp
    // T: O(mn)
    // S: O(m+n)
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= t.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                }
                if (dp[i][j] > 1) {
                    return false;
                }
            }
        }
        return dp[s.length()][t.length()] == 1;
    }
}