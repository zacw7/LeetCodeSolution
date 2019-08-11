class Solution {
    public double new21Game(int N, int K, int W) {
        if (N < K) {
            return 0;
        }
        if (K == 0 || K + W <= N) {
            return 1.0;
        }
        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        double sum = 1.0, res = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            if (i - W >= 0) {
                sum -= dp[i - W];
            }
            if (i < K) {
                sum += dp[i];
            } else {
                res += dp[i];
            }
        }
        return res;
    }
}