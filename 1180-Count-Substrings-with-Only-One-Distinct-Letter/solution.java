class Solution {
    public int countLetters(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int count = 1;
        int left = 0, right = 1;
        while (right < S.length()) {
            if (S.charAt(right) != S.charAt(left)) {
                left = right;
            }
            right++;
            count += right - left;
        }
        return count;
    }
}