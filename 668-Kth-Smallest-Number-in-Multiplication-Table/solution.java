class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numLeX(m, n, mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int numLeX(int m, int n, int x) {
        int res = 0;
        for (int i = 1; i <= m; i++) {
            int lo = 0, hi = n;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2 + 1;
                if (mid * i <= x) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            res += lo;
        }
        return res;
    }
}