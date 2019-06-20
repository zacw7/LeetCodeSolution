class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        int lo = sum / D, hi = sum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isValid(weights, mid, D)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private boolean isValid(int[] weights, int limit, int D) {
        int days = 1, cur = 0;
        for (int w : weights) {
            if (cur + w > limit) {
                cur = 0;
                days++;
            }
            cur += w;
            if (w > limit || days > D) {
                return false;
            }
        }
        return true;
    }
}