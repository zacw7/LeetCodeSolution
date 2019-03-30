class Solution {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[2] * dp[i - 2];
            for (int fac1 = 3, fac2 = i - fac1; fac1 <= fac2; fac1++, fac2--)
                dp[i] = Math.max(dp[i], dp[fac1] * dp[fac2]);
        }
        return dp[n];
    }
}