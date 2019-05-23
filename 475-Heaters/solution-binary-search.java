class Solution {
    // Binary Search
    // TC: O(NlogN + MlogM + MlogN)
    // TC: O(1)
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house : houses) {
            int lo = 0, hi = heaters.length - 1;
            while (lo + 1 < hi) {
                int mid = lo + (hi - lo) / 2;
                if (heaters[mid] < house) {
                    lo = mid;
                } else if (heaters[mid] > house) {
                    hi = mid;
                } else {
                    lo = hi = mid;
                    break;
                }
            }
            radius = Math.max(radius,
                    Math.min(Math.abs(heaters[lo] - house), Math.abs(heaters[hi] - house)));
        }
        return radius;
    }
}