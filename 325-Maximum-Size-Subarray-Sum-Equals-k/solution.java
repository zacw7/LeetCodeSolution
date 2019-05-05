class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sumMap = new HashMap();
        sumMap.put(0, 0);
        int maxLen = 0;
        for (int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i + 1 - sumMap.get(sum - k));
            }
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i + 1);
            }
        }
        return maxLen;
    }
}