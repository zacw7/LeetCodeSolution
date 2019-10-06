class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (int n : arr) {
            map.put(n, map.getOrDefault(n - difference, 0) + 1);
            max = Math.max(max, map.get(n));
        }
        return max;
    }
}