class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int count = map.getOrDefault(n - 1, 0) + map.getOrDefault(n + 1, 0) + 1;
            map.put(n, count);
            if (n > Integer.MIN_VALUE) {
                for (int i = n - 1; i > Integer.MIN_VALUE && map.containsKey(i); i--) map.put(i, count);
            }
            if (n < Integer.MAX_VALUE) {
                for (int i = n + 1; i < Integer.MAX_VALUE && map.containsKey(i); i++) map.put(i, count);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}