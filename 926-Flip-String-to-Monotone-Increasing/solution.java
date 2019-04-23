class Solution {
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        // dp[i][j]: minimum number of flipes
        // i: a prefix substring with length i
        // j: 0 - the i-th character is 0; 1 - the i-th chracter is 1
        int[][] dp = new int[S.length() + 1][2];
        for (int i = 1; i <= S.length(); i++) {
            if (S.charAt(i - 1) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]);
            }
        }
        return Math.min(dp[S.length()][0], dp[S.length()][1]);
    }
}