class Solution {
    // Sliding Window
    // TC: O(N)
    // SC: O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        int res = 0;
        int left = 0, right = 0, product = 1;
        while (right < nums.length) {
            if (nums[right] >= k) {
                left = right = right + 1;
                product = 1;
            } else if (product * nums[right] >= k) {
                product /= nums[left++];
            } else {
                product *= nums[right++];
                res += right - left;
            }
        }
        return res;
    }
}