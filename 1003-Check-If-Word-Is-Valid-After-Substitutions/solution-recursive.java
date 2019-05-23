class Solution {
    // Recursion
    // TC: O(N^2)
    // SC: O(N^2)
    public boolean isValid(String S) {
        if (S.length() == 0) {
            return true;
        }
        if (S.length() % 3 > 0) {
            return false;
        }
        int i = S.indexOf("abc");
        if (i >= 0) {
            return isValid(S.substring(0, i) + S.substring(i + 3, S.length()));
        } else {
            return false;
        }
    }
}