class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        int deltaCount = 0, index = -1;
        int[] charCount = new int[26];
        for (int i = 0; i < A.length(); i++) {
            charCount[A.charAt(i) - 'a']++;
            if (A.charAt(i) != B.charAt(i)) {
                deltaCount++;
                if (deltaCount > 2) return false;
                else if (deltaCount == 1) index = i;
                else if (deltaCount == 2) {
                    if (A.charAt(index) != B.charAt(i) || A.charAt(i) != B.charAt(index)) return false;
                }
            }
        }
        if (deltaCount == 2) {
            return true;
        } else if (deltaCount == 0) {
            for (int i = 0; i < 26; i++) {
                if (charCount[i] >= 2) return true;
            }
        }
        return false;
    }
}