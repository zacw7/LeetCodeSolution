class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = nums.clone();
        ans[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--)
            ans[i] = ans[i + 1] * nums[i + 1];
        int left = 1, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            ans[i] *= left;
        }
        return ans;
    }
}