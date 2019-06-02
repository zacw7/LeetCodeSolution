class Solution {
    // binary search
    // TC: O(logN)
    // SC: 1
    public int missingElement(int[] nums, int k) {
        if (k > nums[nums.length - 1] - nums[0] - nums.length + 1) {
            return k  + nums[0] + nums.length - 1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (k <= nums[mid] - nums[lo] - mid + lo) {
                hi = mid;
            } else {
                k -= nums[mid] - nums[lo] - mid + lo;
                lo = mid;
            }
        }
        return nums[lo] + k;
    }
}