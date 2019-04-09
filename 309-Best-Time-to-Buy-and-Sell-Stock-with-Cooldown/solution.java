class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int[] cash = new int[prices.length];
        int[] hold = new int[prices.length];
        hold[0] = -prices[0];
        cash[1] = Math.max(cash[0], hold[0] + prices[1]);
        hold[1] = Math.max(hold[0], -prices[1]);
        for (int i = 2; i < prices.length; i++) {
            cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
            hold[i] = Math.max(hold[i - 1], cash[i - 2] - prices[i]);
        }
        return cash[prices.length - 1];
    }
}