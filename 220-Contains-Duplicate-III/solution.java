class Solution {
    // TreeMap
    // TC: O(nlogt)
    // SC: O(t)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) {
            return false;
        }
        TreeMap<Long, Integer> map = new TreeMap();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                int cnt = map.get((long)nums[i - k - 1]) - 1;
                if (cnt == 0) {
                    map.remove((long)nums[i - k - 1]);
                } else {
                    map.put((long)nums[i - k - 1], cnt);
                }
            }
            Long x = map.ceilingKey((long)nums[i] - t);
            if (x != null && Math.abs(nums[i] - x) <= t) {
                return true;
            }
            map.put((long)nums[i], map.getOrDefault((long)nums[i], 0) + 1);
        }
        return false;
    }
}