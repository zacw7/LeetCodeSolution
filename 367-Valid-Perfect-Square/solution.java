class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = 46340;
        if (num == lo || num == hi * hi) return true;
        if (num < lo || num > hi * hi) return false;
        int mid = lo + (hi - lo) / 2;
        while (lo < hi - 1) {
            if (mid * mid == num) return true;
            if (mid * mid > num) hi = mid;
            else lo = mid;
            mid = lo + (hi - lo) / 2;
        }
        return false;
    }
}