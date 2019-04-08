class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int lo = 0, hi = 46340;
        if (x >= hi * hi) return hi;
        int mid = hi - (hi - lo) / 2;
        while (mid * mid != x) {
            if (mid * mid > x) hi = mid;
            else {
                if ((mid + 1) * (mid + 1) > x ) break;
                lo = mid;
            }
            mid = hi - (hi - lo) / 2;
        }
        return mid;
    }
}