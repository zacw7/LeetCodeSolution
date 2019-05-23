class Solution {
    // Binary Search
    // TC: O(Log(20000))
    // SC: O(1)
    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = 20000;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int cur = reader.get(mid);
            if (cur == target) {
                return mid;
            } else if (cur > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (reader.get(lo) == target) {
            return lo;
        } else if (reader.get(hi) == target) {
            return hi;
        } else {
            return -1;
        }
    }
}