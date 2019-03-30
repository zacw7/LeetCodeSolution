class Solution {
    public int minSteps(int n) {
        if (n <= 1) return 0;
        int[] memo = new int[n + 1];
        dp(memo, n);
        return memo[n];
    }

    private void dp(int[] memo, int n) {
        if (n <= 3) memo[n] = n;
        memo[n] = n;
        for (int k = 2, root = (int)Math.sqrt(n); k <= root; k++) {
            if (n % k > 0) continue;
            if (memo[n / k] == 0) dp(memo, n / k);
            memo[n] = Math.min(memo[n], k + memo[n / k]);
        }
    }
}