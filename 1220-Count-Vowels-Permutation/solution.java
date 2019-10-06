class Solution {
    public int countVowelPermutation(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 5;
        }
        int MOD = 1_000_000_007;
        // 'a', 'e', 'i', 'o', 'u'
        long[][] dp = new long[n][256];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i]['e'] = dp[i - 1]['a'] + dp[i - 1]['i'];
            dp[i]['e'] %= MOD;
            dp[i]['a'] = dp[i - 1]['e'] + dp[i - 1]['i'] + dp[i - 1]['u'];
            dp[i]['a'] %= MOD;
            dp[i]['i'] = dp[i - 1]['e'] + dp[i - 1]['o'];
            dp[i]['i'] %= MOD;
            dp[i]['u'] = dp[i - 1]['o'] + dp[i - 1]['i'];
            dp[i]['u'] %= MOD;
            dp[i]['o'] = dp[i - 1]['i'];
            dp[i]['o'] %= MOD;
        }
        int res = 0;
        for (long d : dp[n - 1]) {
            res += d % MOD;
            res %= MOD;
        }
        return res;
    }
}