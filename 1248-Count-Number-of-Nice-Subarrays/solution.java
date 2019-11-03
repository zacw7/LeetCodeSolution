class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap();
        countMap.put(0, -1);
        int cur = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                cur++;
            }
            countMap.putIfAbsent(cur, i);
            if (cur >= k) {
                res += countMap.get(cur - k + 1) - countMap.get(cur - k);
            }
        }
        return res;
    }
}