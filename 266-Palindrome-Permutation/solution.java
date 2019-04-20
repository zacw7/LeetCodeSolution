class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }

        int[] count = new int[256];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        boolean evenChar = false;
        for (int i = 0; i < 256; i++) {
            if (count[i] % 2 == 1) {
                if (evenChar) {
                    return false;
                }
                evenChar = true;
            }
        }
        return true;
    }
}