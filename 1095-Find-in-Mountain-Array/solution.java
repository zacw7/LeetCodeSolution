/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int LEN = mountainArr.length();
        if (LEN <= 0) {
            return -1;
        }
        if (mountainArr.get(0) == target) {
            return 0;
        }
        int peak = findPeakElement(LEN, mountainArr);
        // find in the left
        int lo = 0, hi = peak;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int midNum = mountainArr.get(mid);
            if (midNum < target) {
                lo = mid + 1;
            } else if (midNum > target) {
                hi = mid;
            } else {
                return mid;
            }
        }
        if (mountainArr.get(lo) == target) {
            return lo;
        }
        // find int he right
        lo = peak + 1;
        hi = LEN - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int midNum = mountainArr.get(mid);
            if (midNum > target) {
                lo = mid + 1;
            } else if (midNum < target) {
                hi = mid;
            } else {
                return mid;
            }
        }
        if (mountainArr.get(lo) == target) {
            return lo;
        }
        return -1;
    }

    public int findPeakElement(int LEN, MountainArray mountainArr) {
        if (LEN <= 0) {
            return -1;
        }
        int lo = 0, hi = LEN - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int midNum = mountainArr.get(mid), midNext = mountainArr.get(mid + 1);
            if (midNum > midNext) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}