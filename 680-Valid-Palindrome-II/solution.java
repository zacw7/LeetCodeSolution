class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() < 3) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // try delete left
                int nLeft = left + 1;
                int nRight = right;
                while (nLeft < nRight) {
                    if (s.charAt(nLeft) == s.charAt(nRight)) {
                        nLeft++;
                        nRight--;
                    } else {
                        break;
                    }
                }
                if (nLeft >= nRight) return true;
                // try delete right
                nLeft = left;
                nRight = right - 1;
                while (nLeft < nRight) {
                    if (s.charAt(nLeft) == s.charAt(nRight)) {
                        nLeft++;
                        nRight--;
                    } else {
                        break;
                    }
                }
                return nLeft >= nRight;
            }
        }
        return true;
    }
}