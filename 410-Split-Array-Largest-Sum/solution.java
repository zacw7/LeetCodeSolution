class Solution {
    // dp
    // T: O(mn)
    // S: O(mn)
    public int splitArray(int[] nums, int m) {
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        // dp[i][j]: the minimun largest sum of the first i numbers split j times.
        long[][] dp = new long[m][nums.length + 1];
        for (int j = 1; j <= nums.length; j++) {
            dp[0][j] = prefixSums[j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= nums.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[i - 1][k], prefixSums[j] - prefixSums[k]));
                }
            }
        }
        return (int) dp[m - 1][nums.length];
    }
}