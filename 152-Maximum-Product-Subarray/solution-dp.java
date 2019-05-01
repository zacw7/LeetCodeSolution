class Solution {
    // dp
    // T: O(n)
    // S: O(n)
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[0] = max[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
            max[i] = Math.max(nums[i], Math.max(min[i - 1] * nums[i], max[i - 1] * nums[i]));
        }
        int ans = 0;
        for (int m : max) {
            ans = Math.max(ans, m);
        }
        return ans;
    }
}