class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] < nums[hi]) return nums[lo];
        if (nums[hi] < nums[hi - 1]) return nums[hi];
        int mid = hi - (hi - lo) / 2;
        while (nums[mid] > nums[mid - 1]) {
            if (nums[mid] > nums[lo]) lo = mid;
            else hi = mid;
            mid = hi - (hi - lo) / 2;
        }
        return nums[mid];
    }
}