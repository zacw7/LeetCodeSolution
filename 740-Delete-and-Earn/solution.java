class Solution {
    // dp
    // T: O(n)
    // S: O(n)
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> numCountMap = new HashMap();
        for (int n : nums) {
            numCountMap.put(n, numCountMap.getOrDefault(n, 0) + 1);
        }
        int[] keys = new int[numCountMap.size()];
        int i = 0;
        for (Integer n : numCountMap.keySet()) {
            keys[i++] = n;
        }
        Arrays.sort(keys);
        int[] dp = new int[keys.length];
        dp[0] = keys[0] * numCountMap.get(keys[0]);
        if (keys[1] == keys[0] + 1) {
            dp[1] = Math.max(dp[0], keys[1] * numCountMap.get(keys[1]));
        } else {
            dp[1] = dp[0] + keys[1] * numCountMap.get(keys[1]);
        }

        for (i = 2; i < dp.length; i++) {
            if (keys[i] == keys[i - 1] + 1) {
                dp[i] = Math.max(dp[i - 1], keys[i] * numCountMap.get(keys[i]) + dp[i - 2]);
            } else {
                dp[i] = dp[i - 1] + keys[i] * numCountMap.get(keys[i]);
            }
        }
        return dp[dp.length - 1];
    }
}