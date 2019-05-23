class Solution {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}