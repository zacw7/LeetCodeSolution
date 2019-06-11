class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap();
        prefixSumMap.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum - k)) {
                max = Math.max(max, i - prefixSumMap.get(sum - k));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return max;
    }
}