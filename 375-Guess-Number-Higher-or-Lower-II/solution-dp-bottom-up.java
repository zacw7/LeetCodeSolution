class Solution {
    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[][] memo = new int[n + 1][n + 1];
        for (int lo = 1; lo <= n - 1; lo++) memo[lo][lo + 1] = lo;
        for (int lo = 1; lo <= n - 2; lo++) memo[lo][lo + 2] = lo + 1;
        for (int delta = 3; delta < n; delta++) {
            for (int lo = 1, hi = lo + delta; hi <= n; lo++, hi++) {
                memo[lo][hi] = Math.min(lo + memo[lo + 1][hi], hi + memo[lo][hi - 1]);
                for (int i = lo + 1; i < hi; i++) {
                    memo[lo][hi] = Math.min(memo[lo][hi], i + Math.max(memo[lo][i - 1],memo[i + 1][hi]));
                }
            }
        }
        return memo[1][n];
    }
}