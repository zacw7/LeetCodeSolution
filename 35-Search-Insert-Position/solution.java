class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                return mid;
            }
        }
        if (target > nums[hi]) {
            return hi + 1;
        } else if (target > nums[lo]) {
            return hi;
        } else {
            return lo;
        }
    }
}