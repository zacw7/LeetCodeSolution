class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int n : nums) {
            int[] tmp = dp.clone();
            dp[n % 3] = Math.max(tmp[n % 3], tmp[0] + n);

            if (tmp[1] > 0) {
                dp[(1 + n) % 3] = Math.max(tmp[(1 + n) % 3], tmp[1] + n);
            }

            if (tmp[2] > 0) {
                dp[(2 + n) % 3] = Math.max(tmp[(2 + n) % 3], tmp[2] + n);
            }
        }
        return dp[0];
    }
}