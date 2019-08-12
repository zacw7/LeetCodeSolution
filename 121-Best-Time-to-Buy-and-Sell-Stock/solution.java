class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, minBuy = Integer.MAX_VALUE;
        for (int p : prices) {
            profit = Math.max(profit, p - minBuy);
            minBuy = Math.min(minBuy, p);
        }
        return profit;
    }
}