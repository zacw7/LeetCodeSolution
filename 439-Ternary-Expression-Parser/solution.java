class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() <= 1) {
            return expression;
        }
        int unmatch = 0;
        for (int i = 1; i < expression.length(); i++) {
            char c  = expression.charAt(i);
            if (c == '?') {
                unmatch++;
            } else if (c == ':') {
                unmatch--;
            }
            if (unmatch == 0) {
                if (expression.charAt(0) == 'T') {
                    return parseTernary(expression.substring(2, i));
                } else if (expression.charAt(0) == 'F') {
                    return parseTernary(expression.substring(i + 1));
                }
            }
        }
        return expression;
    }
}