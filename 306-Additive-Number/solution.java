class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (len - i - j < i || len - i - j < j) break;
                if (helper(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean helper(String num, int index, int len1, int len2) {
        if (index + len1 + len2 == num.length()) return true;
        String n1Str = num.substring(index, index + len1);
        String n2Str = num.substring(index + len1, index + len1 + len2);
        if (len1 > 1 && n1Str.startsWith("0")) return false;
        if (len2 > 1 && n2Str.startsWith("0")) return false;
        long n1 = Long.valueOf(n1Str);
        long n2 = Long.valueOf(n2Str);
        long n3 = n1 + n2;
        String n3Str = String.valueOf(n3);
        int len3 = n3Str.length();
        if (index + len1 + len2 + len3 > num.length()
                || !n3Str.equals(num.substring(index + len1 + len2, index + len1 + len2 + len3))) return false;
        return helper(num, index + len1, len2, len3);
    }
}