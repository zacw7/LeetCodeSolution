class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        return dp(s, 0);
    }

    public int dp(String s, int i) {
        if (i < s.length() && s.charAt(i) == '0') return 0;
        if (i == s.length() || i == s.length() - 1) return 1;
        int count = dp(s, i + 1);
        int doubleDigit = Integer.valueOf(s.substring(i, i + 2));
        if (doubleDigit >= 10 && doubleDigit <= 26) count += dp(s, i + 2);
        return count;
    }
}