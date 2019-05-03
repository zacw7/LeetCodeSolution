class Solution {
    // DP - buy and sell
    // Time: O(kn)
    // Space: O(k)
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        if (prices.length / 2 < k) {
            return quickSolve(prices);
        }
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

    private int quickSolve(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}