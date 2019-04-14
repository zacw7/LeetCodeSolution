class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }
}