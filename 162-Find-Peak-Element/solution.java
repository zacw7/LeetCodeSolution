class Solution {
    // binary search
    // T: O(logn)
    // S: O(1)
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if ((lo == 0 || nums[lo] > nums[lo - 1]) && nums[lo] > nums[lo + 1]) {
            return lo;
        } else {
            return hi;
        }
    }
}