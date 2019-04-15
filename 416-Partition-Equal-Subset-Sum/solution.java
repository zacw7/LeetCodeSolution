class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 > 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                if (dp[i][j] && j + nums[i] <= target) {
                    dp[i + 1][j] = dp[i + 1][j + nums[i]] = true;
                    if (j + nums[i] == target) return true;
                }
            }
        }
        return false;
    }
}