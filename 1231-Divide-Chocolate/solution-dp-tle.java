class Solution {
    // binary search
    // TC: O(nlogn)
    // SC: O(1)
    public int maximizeSweetness(int[] sweetness, int K) {
        int N = sweetness.length;
        int sum = 0;
        for (int n : sweetness) {
            sum += n;
        }
        int lo = 0, hi = sum / (K + 1);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1; // hi biased
            if (isValid(sweetness, mid, K + 1)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean isValid(int[] sweetness, int min, int K) {
        int cur = 0;
        for (int n : sweetness) {
            cur += n;
            if (cur >= min) {
                cur = 0;
                K--;
                if (K == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}