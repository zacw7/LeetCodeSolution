class Solution {
    public int longestPalindrome(String s) {
        int[] charCount = new int[52];
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') charCount[ch - 'a']++;
            else if (ch >= 'A' && ch <= 'Z') charCount[ch - 'A' + 26]++;
        }
        int centralChar = 0, ans = 0;
        for (int count : charCount) {
            if (centralChar == 0 && count % 2 == 1) centralChar = 1;
            ans += (count >> 1) << 1;
        }
        return ans + centralChar;
    }
}