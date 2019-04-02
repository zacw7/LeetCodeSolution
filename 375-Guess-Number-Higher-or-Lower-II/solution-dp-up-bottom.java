class Solution {
    public int getMoneyAmount(int n) {
        return dp(1, n);
    }

    public int dp(int lo, int hi) {
        if (lo >= hi) return 0;
        if (lo == hi - 1) return lo;
        if (lo == hi - 2) return lo + 1;
        int min = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            int cur = i;
            min = Math.min(min, cur + Math.max(dp(lo, i - 1), dp(i + 1, hi)));
        }
        return min;
    }
}