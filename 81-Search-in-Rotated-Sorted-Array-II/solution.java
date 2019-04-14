class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int splitPoint = 1;
        while (splitPoint < nums.length && nums[splitPoint] >= nums[splitPoint - 1]) {
            splitPoint++;
        }
        int lo, hi, mid;
        if (splitPoint >= nums.length) {
            lo = 0;
            hi = nums.length - 1;
        } else {
            if (target >= nums[0]) {
                lo = 0;
                hi = splitPoint - 1;
            } else {
                lo = splitPoint;
                hi = nums.length - 1;
            }
        }
        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target ) {
                return true;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return nums[lo] == target || nums[hi] == target;
    }
}