class Solution {

    private Random rand;
    private int[] weights;

    public Solution(int[] w) {
        this.rand = new Random();
        this.weights = new int[w.length];

        weights[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            weights[i] = weights[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int w = rand.nextInt(weights[weights.length - 1]);
        int lo = 0, hi = weights.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (weights[mid] <= w) {
                lo = mid;
            } else if (weights[mid - 1] > w) {
                hi = mid;
            } else {
                return mid;
            }
        }
        if (w < weights[hi] && w >= weights[lo]) {
            return hi;
        } else {
            return lo;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */