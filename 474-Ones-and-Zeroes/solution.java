class Solution {
    // dp
    // TC: O(k*m*n)
    // SC: O(m*n)
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int max = 0;
        dp[m][n] = 0;
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = 0; i <= m ; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i + zeros <= m && j + ones <= n && dp[i + zeros][j + ones] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + zeros][j + ones] + 1);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}