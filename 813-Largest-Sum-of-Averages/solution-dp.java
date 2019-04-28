class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        double[] prefixSums = new double[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + A[i - 1];
        }
        double[][] dp = new double[K][A.length];
        for (int j = 0; j < A.length; j++) {
            dp[0][j] = prefixSums[j + 1] / (j + 1);
        }
        for (int k = 1; k < K; k++) {
            for (int i = 0; i < A.length; i++) {
                dp[k][i] = prefixSums[i + 1] / (i + 1);
                for (int j = 0; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i],
                            dp[k - 1][j] + (prefixSums[i + 1] - prefixSums[j + 1]) / (i - j));
                }
            }
        }
        return dp[K - 1][A.length - 1];
    }
}