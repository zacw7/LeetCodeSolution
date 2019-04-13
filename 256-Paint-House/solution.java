class Solution {
    // T: O(N)
    // S: O(1)
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int[] dp = new int[3];
        for (int i = 0; i < costs.length; i++) {
            int[] prev = dp.clone();
            dp[0] = costs[i][0] + Math.min(prev[1], prev[2]);
            dp[1] = costs[i][1] + Math.min(prev[0], prev[2]);
            dp[2] = costs[i][2] + Math.min(prev[0], prev[1]);
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}