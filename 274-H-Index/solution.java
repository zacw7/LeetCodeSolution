class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        if (citations.length == 1) return Math.min(citations[0], 1);
        int sum = 0;
        int lo = 0, hi = citations.length;
        if (calcH(citations, lo) >= lo && calcH(citations, lo + 1) < lo + 1) return lo;
        if (hi == calcH(citations, hi)) return hi;
        int mid = lo + (hi - lo) / 2;
        int max = 0;
        while (lo < hi - 1) {
            int count = calcH(citations, mid);
            if (count < mid) hi = mid;
            else {
                if (calcH(citations, mid + 1) < mid + 1) return mid;
                else lo = mid;
            }
            mid = lo + (hi - lo) / 2;
        }
        return 0;
    }

    private int calcH(int[] citations, int n) {
        int count = 0;
        for (int c : citations) {
            if (c >= n) count++;
        }
        return count;
    }
}