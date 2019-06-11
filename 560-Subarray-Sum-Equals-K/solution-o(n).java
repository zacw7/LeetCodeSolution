class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap();
        prefixSumCount.put(0, 1);
        int sum = 0, count = 0;
        for (int n : nums) {
            sum += n;
            count += prefixSumCount.getOrDefault(sum - k, 0);
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}