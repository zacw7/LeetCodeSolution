class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int LEN1 = str1.length(), LEN2 = str2.length();
        if (LEN1 == 0) {
            return str2;
        } else if (LEN2 == 0) {
            return str1;
        }

        StringBuilder[][] dp = new StringBuilder[LEN1 + 1][LEN2 + 1];
        dp[0][0] = new StringBuilder();
        for (int i = 1; i <= LEN2; i++) {
            dp[0][i] = new StringBuilder(dp[0][i - 1]);
            dp[0][i].append(str2.charAt(i - 1));
        }
        for (int i = 1; i <= LEN1; i++) {
            char c1 = str1.charAt(i - 1);
            dp[i][0] = new StringBuilder(dp[i - 1][0]);
            dp[i][0].append(c1);
            for (int j = 1; j <= LEN2; j++) {
                char c2 = str2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = new StringBuilder(dp[i - 1][j - 1]);
                    dp[i][j].append(c1);
                } else if (dp[i - 1][j].length() <= dp[i][j - 1].length()) {
                    dp[i][j] = new StringBuilder(dp[i - 1][j]);
                    dp[i][j].append(c1);
                } else {
                    dp[i][j] = new StringBuilder(dp[i][j - 1]);
                    dp[i][j].append(c2);
                }
            }
            if (i > 2) {
                Arrays.fill(dp[i - 2], null);
            }
        }
        return dp[LEN1][LEN2].toString();
    }
}