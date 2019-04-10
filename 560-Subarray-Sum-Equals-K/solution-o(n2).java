class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k) count++;
            }
        }
        return count;
    }
}