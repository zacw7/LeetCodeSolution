class Solution {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        int i = 0;
        while(i < S.length() && len < K) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                len *= c - '0';
            } else {
                len++;
            }
            i++;
        }
        while (i-- > 0) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                len /= c - '0';
                K %= len;
            } else {
                if (K % len-- == 0) {
                    return String.valueOf(c);
                }
            }
        }
        return "";
    }
}