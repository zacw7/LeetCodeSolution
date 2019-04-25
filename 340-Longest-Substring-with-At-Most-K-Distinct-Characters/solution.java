class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int[] charCount = new int[256];
        int maxLen = 0;
        int left = 0, right = 0;
        while (right <= s.length()) {
            if (count <= k) {
                maxLen = Math.max(maxLen, right - left);
                if (right < s.length()) {
                    if (charCount[s.charAt(right)] == 0) {
                        count++;
                    }
                    charCount[s.charAt(right)]++;
                }
                right++;
            } else {
                charCount[s.charAt(left)]--;
                if (charCount[s.charAt(left)] == 0) {
                    count--;
                }
                left++;
            }
        }
        return maxLen;
    }
}