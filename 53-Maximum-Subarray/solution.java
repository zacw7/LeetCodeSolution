class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = nums[i - 1] + sums[i - 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                max = Math.max(max, sums[j] - sums[i]);
            }
        }
        return max;
    }
}