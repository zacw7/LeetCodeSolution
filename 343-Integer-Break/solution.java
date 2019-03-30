class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = dp[1] = 1;
        for (int i = 3; i <= n; i++) {
            int cur = 2 * Math.max(i - 2, dp[i - 2]);
            for (int fac1 = 3, fac2 = i - fac1; fac1 <= fac2; fac1++, fac2--) {
                cur = Math.max(cur, Math.max(fac1, dp[fac1]) * Math.max(fac2, dp[fac2]));
            }
            dp[i] = cur;
        }
        return dp[n];
    }
}