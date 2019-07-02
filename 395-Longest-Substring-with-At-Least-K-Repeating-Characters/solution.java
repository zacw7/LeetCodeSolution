class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0 || s.length() < k) {
            return 0;
        }
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            count[c - 'a']++;
        }
        boolean valid = true;
        for (int c : count) {
            if (c > 0 && c < k) {
                valid = false;
                break;
            }
        }
        if (valid) {
            return s.length();
        }
        int max = 0;
        int l = 0;
        while (l < chs.length && count[chs[l] - 'a'] < k) {
            l++;
        }
        int r = l + 1;
        while (r <= chs.length) {
            if (r == chs.length || count[chs[r] - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(l, r), k));
                l = r + 1;
                while (l < chs.length && count[chs[l] - 'a'] < k) {
                    l++;
                }
                r = l + 1;
            } else {
                r++;
            }
        }
        return max;
    }
}