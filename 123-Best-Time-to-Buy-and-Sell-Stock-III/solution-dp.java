class Solution {
    // DP
    // T: O(n)
    // S: O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        int maxSell = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            dp[1][i] = Math.max(dp[1][i + 1], maxSell - prices[i]);
            maxSell = Math.max(maxSell, prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, dp[0][i] + dp[1][i]);
        }
        return profit;
    }
}