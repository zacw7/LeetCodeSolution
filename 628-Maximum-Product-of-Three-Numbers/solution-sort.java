class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int N = nums.length;
        return Math.max(nums[N - 1] * nums[N - 2] * nums[N - 3], nums[0] * nums[1] * nums[N - 1]);
    }
}