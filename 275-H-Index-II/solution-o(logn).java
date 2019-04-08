class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0 || citations[citations.length - 1] == 0) return 0;
        if (citations[0] >= citations.length) return citations.length;
        int lo = 0, hi = citations.length, mid = lo + (hi - lo) / 2;
        while (lo < hi - 1) {
            if (citations[citations.length - mid] >= mid) {
                if (citations[citations.length - mid - 1] < mid + 1) break;
                lo = mid;
            } else {
                hi = mid;
            }
            mid = lo + (hi - lo) / 2;
        }
        return mid;
    }
}