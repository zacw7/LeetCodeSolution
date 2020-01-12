class Solution {
    public int minInsertions(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }
        return minInsertions(0, N - 1, s, dp);
    }

    private int minInsertions(int i, int j, String s, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] == -1) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = minInsertions(i + 1, j - 1, s, dp);
            } else {
                dp[i][j] = 1 + Math.min(minInsertions(i + 1, j, s, dp), minInsertions(i, j - 1, s, dp));
            }
        }
        return dp[i][j];
    }
}