class Solution {

    private int[] wIdx;
    private Random rand;
    private int fullWeight;

    public Solution(int[] w) {
        if (w == null || w.length == 0) {
            return;
        }
        this.wIdx = new int[w.length];
        this.rand = new Random();

        wIdx[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            wIdx[i] = wIdx[i - 1] + w[i];
        }
        this.fullWeight = wIdx[wIdx.length - 1];
    }

    public int pickIndex() {
        if (wIdx.length == 1) {
            return 0;
        }
        int n = rand.nextInt(fullWeight);
        int lo = 0, hi = wIdx.length - 1;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (n > wIdx[mid]) {
                lo = mid;
            } else if (n < wIdx[mid]) {
                if (n >= wIdx[mid - 1]) {
                    return mid;
                } else {
                    hi = mid;
                }
            } else {
                return mid + 1;
            }
        }
        if (wIdx[hi] > n && wIdx[hi - 1] <= n) {
            return hi;
        }
        if (lo == 0) {
            return 0;
        } else if (wIdx[lo] > n && wIdx[lo - 1] <= n) {
            return lo;
        }

        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */