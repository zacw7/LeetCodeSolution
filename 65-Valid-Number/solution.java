class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean valid = false;
        boolean sign = false;
        boolean isDecimal = false;
        boolean isScentific = false;
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (sign) {
                    return false;
                }
            } else if (c == '.') {
                sign = true;
                if (isDecimal) {
                    return false;
                } else {
                    isDecimal = true;
                }
            } else if (c == 'e') {
                if (isScentific || !valid) {
                    return false;
                } else {
                    isScentific = true;
                    isDecimal = true;
                    valid = false;
                    sign = false;
                }
            } else if (c >= '0' && c <= '9') {
                sign = true;
                valid = true;
            } else {
                return false;
            }
        }
        return valid;
    }
}