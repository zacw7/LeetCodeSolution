class Solution {
    public int numberOfWays(int num_people) {
        int MOD = 1_000_000_007;
        if (num_people <= 1) {
            return 0;
        }
        long[] dp = new long[num_people / 2 + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
                dp[i] %= MOD;
            }
        }
        return (int) dp[num_people / 2];
    }
}