class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] memo = new int[s.length() + 1];
        memo[0] = memo[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') memo[i] += memo[i - 1];
            int doubleDigit = Integer.valueOf(s.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) memo[i] += memo[i - 2];
        }
        return memo[s.length()];
    }
}