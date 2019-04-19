class Solution {
    // T: O(n^2)
    // S: O(1)
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, profitHelper(prices, 0, i) + profitHelper(prices, i + 1, prices.length - 1));
        }
        return max;
    }

    private int profitHelper(int[] prices, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int profit = 0, hold = prices[start];
        for (int i = start + 1; i <= end; i++) {
            profit = Math.max(profit, prices[i] - hold);
            hold = Math.min(hold, prices[i]);
        }

        return profit;
    }
}