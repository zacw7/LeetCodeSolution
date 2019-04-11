class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int n : nums) set.add(n);
        int ans = 0;
        for (int n : nums) {
            int cur = 0;
            if (n == Integer.MIN_VALUE || !set.contains(n - 1)) {
                while (set.contains(n++)) cur++;
            }
            ans = Math.max(cur, ans);
        }
        return ans;
    }
}