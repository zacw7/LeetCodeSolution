class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int count = 0;
        for (int i = 1, prev = 0; i <= nums.length; i++) {
            int sum = prev + nums[i - 1];
            prev = sum;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}