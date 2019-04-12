class Solution {
    // T: O(kn)
    // S: O(1)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (nums.length <= k) {
            int max = 0;
            for (int n : nums) max = Math.max(max, n);
            return new int[]{max};
        }
        int[] ans = new int[nums.length - k + 1];
        if (k > 0){
            for (int i = 0; i <= nums.length - k; i++) {
                int max = nums[i];
                for (int j = 1; j < k; j++) max = Math.max(max, nums[i + j]);
                ans[i] = max;
            }
        }
        return ans;
    }
}