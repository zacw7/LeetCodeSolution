class Solution {
    public int minSteps(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int k = 2, root = (int)Math.sqrt(i); k <= root; k++) {
                if (i % k > 0) continue;
                dp[i] = Math.min(dp[i], k + dp[i / k]);
            }
        }
        return dp[n];
    }
}