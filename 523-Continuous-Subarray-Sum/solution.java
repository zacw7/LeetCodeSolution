class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] prefixSums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 2; j <= nums.length; j++) {
                if (k == 0) {
                    if (prefixSums[j] - prefixSums[i] == 0) {
                        return true;
                    }
                } else {
                    if ((prefixSums[j] - prefixSums[i]) % k == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}