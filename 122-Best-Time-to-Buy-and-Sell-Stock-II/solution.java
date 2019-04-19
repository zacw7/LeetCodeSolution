class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int profit = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] + hold);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }
}