class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[256];
        int l = 0, r = 0;
        int maxLen = 0;
        int distinct = 0;
        while (r < s.length()) {
            count[s.charAt(r)]++;
            if (count[s.charAt(r)] == 1) {
                distinct++;
            }
            r++;
            while (distinct > 2) {
                count[s.charAt(l)]--;
                if (count[s.charAt(l)] == 0) {
                    distinct--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }
}