class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] count = new int[256];
        int lo = 0, hi = 0;
        while (hi < s.length()) {
            char c = s.charAt(hi++);
            count[c]++;
            while (count[c] > 1) {
                count[s.charAt(lo++)]--;
            }
            maxLen = Math.max(maxLen, hi - lo);
        }
        return maxLen;
    }
}