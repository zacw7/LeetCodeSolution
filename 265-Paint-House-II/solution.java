class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) return 0;
        int k = costs[0].length;
        int[] dp = new int[k], minPrev = new int[k];
        for (int i = 0; i < costs.length; i++) {
            int[] prev = dp.clone();
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                dp[j] = costs[i][j] + minPrev[j];
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                } else if (dp[j] < min2) min2 = dp[j];
            }
            for (int j = 0; j < k; j++) {
                if (dp[j] > min1) minPrev[j] = min1;
                else minPrev[j] = min2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int d : dp) min = Math.min(min, d);
        return min;
    }
}