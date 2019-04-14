class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        int mid;

        while (lo + 1 < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] < nums[lo] && target > nums[hi]) hi = mid;
                else lo = mid;
            } else {
                if (nums[mid] > nums[hi] && target < nums[lo]) lo = mid;
                else hi = mid;
            }
        }

        if (nums[lo] == target) return lo;
        if (nums[hi] == target) return hi;
        return -1;
    }
}