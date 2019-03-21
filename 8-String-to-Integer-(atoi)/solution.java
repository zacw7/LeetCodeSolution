class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int ans = 0, len = str.length();
        if (len == 0) return ans;
        int sign = 1, i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            if (str.charAt(0) == '-') sign = -1;
            i = 1;
        }
        while (i < len && str.charAt(i) == '0') i++;
        while (i < len) {
            char ch = str.charAt(i);
            int digit = (ch - '0') * sign;
            if (ch >= '0' && ch <= '9') {
                if (sign == 1 && ans > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && ans < (Integer.MIN_VALUE - digit) / 10) {
                    return Integer.MIN_VALUE;
                }
                ans *= 10;
                ans += digit;
            } else {
                break;
            }
            i++;
        }
        return ans;
    }
}