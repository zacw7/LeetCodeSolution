class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] charCount = new int[256];
        int maxLen = 0;
        int left = 0, right = 0;
        while (right <= s.length()) {
            if (isValid(charCount)) {
                maxLen = Math.max(maxLen, right - left);
                if (right < s.length()) {
                    charCount[s.charAt(right)]++;
                }
                right++;
            } else {
                charCount[s.charAt(left)]--;
                left++;
            }
        }
        return maxLen;
    }

    private boolean isValid(int[] cc) {
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (cc[i] > 0) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}