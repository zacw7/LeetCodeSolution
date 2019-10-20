class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int N = prob.length;
        double[][] dp = new double[N + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            double p = prob[i - 1];
            dp[i][0] = dp[i - 1][0] * (1 - p);
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j] * (1 - p) + dp[i - 1][j - 1] * p;
            }
        }
        return dp[N][target];
    }
}