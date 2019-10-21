class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int[] count = new int[26];
        int maxLen = 0;
        while (r < s.length()) {
            count[s.charAt(r) - 'A']++;
            r++;
            while (!isValid(count, r - l, k)) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(r - l, maxLen);
        }
        return maxLen;
    }

    private boolean isValid(int[] count, int sum, int k) {
        for (int n : count) {
            if (sum - n <= k) {
                return true;
            }
        }
        return false;
    }
}