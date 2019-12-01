class Solution {
    public int palindromePartition(String s, int k) {
        if (s.length() == k) {
            return 0;
        }
        int[][][] dp = new int[s.length()][s.length()][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int m = 0; m < dp[i][j].length; m++) {
                    dp[i][j][m] = -1;
                }
            }
        }
        return palindromePartition(s, k, 0, s.length() - 1, dp);
    }

    private int palindromePartition(String s, int k, int start, int end, int[][][] dp) {
        if (end - start + 1 == k) {
            return 0;
        }
        if (dp[start][end][k] >= 0) {
            return dp[start][end][k];
        }
        if (k == 1) {
            dp[start][end][k] = minChange(s, start, end);
            return dp[start][end][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = 1; k - j > 0 && j <= i - start + 1 && k - j <= end - i; j++) {
                res = Math.min(res, palindromePartition(s, j, start, i, dp) + palindromePartition(s, k - j, i + 1, end, dp));
            }
        }
        dp[start][end][k] = res;
        return res;
    }

    private int minChange(String s, int i, int j) {
        int res = 0;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                res++;
            }
        }
        return res;
    }
}