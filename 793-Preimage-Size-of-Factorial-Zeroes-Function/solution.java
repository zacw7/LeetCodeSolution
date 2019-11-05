class Solution {
    public int preimageSizeFZF(int K) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = zeroCount(mid);
            if (count < K) {
                lo = mid + 1;
            } else if (count > K) {
                hi = mid - 1;
            } else {
                return 5;
            }
        }
        return 0;
    }

    private long zeroCount(long num) {
        long res = 0;
        long base = 5;
        while (num / base > 0) {
            res += num / base;
            base *= 5;
        }
        return res;
    }
}