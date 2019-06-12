class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int lo = 1, hi = piles[piles.length - 1];
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(mid, piles, H)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (canFinish(lo, piles, H)) {
            return lo;
        } else {
            return hi;
        }
    }

    private boolean canFinish(int speed, int[] piles, int H) {
        int t = 0;
        for (int p : piles) {
            t += p / speed;
            if (p % speed > 0) {
                t++;
            }
        }
        return t <= H;
    }
}