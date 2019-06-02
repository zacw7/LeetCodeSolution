class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) {
            return "";
        }
        if (str1.length() < str2.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        if (!isValid(str1, str2)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private boolean isValid(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i % s2.length())) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}