class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[] seen = new boolean[256];
        seen[s.charAt(0)] = true;
        int max = 0;
        int left = 0, right = 1;
        while (right < s.length()) {
            if (seen[s.charAt(right)]) {
                if (right - left > max) max = right - left;
                while (s.charAt(left) != s.charAt(right)) seen[s.charAt(left++)] = false;
                left++;
            }
            seen[s.charAt(right++)] = true;
        }
        if (right - left > max) max = right - left;
        return max;
    }
}