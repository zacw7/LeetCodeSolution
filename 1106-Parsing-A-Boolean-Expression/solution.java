class Solution {
    public boolean parseBoolExpr(String expression) {
        if (expression == null || expression.length() == 0) {
            return false;
        }
        int c = expression.charAt(0);
        if (c == 'f') {
            return false;
        } else if (c == 't') {
            return true;
        } else if (c == '!') {
            return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        } else if (c == '&') {
            int unmatch = 0;
            int left = 2, right = 3;
            while (right < expression.length()) {
                char cur = expression.charAt(right);
                if (cur == '(') {
                    unmatch++;
                }
                if (cur == ')') {
                    unmatch--;
                }
                if (unmatch < 0 || (cur == ',' && unmatch == 0)) {
                    if (!parseBoolExpr(expression.substring(left, right))) {
                        return false;
                    }
                    left = right + 1;
                }
                right++;
            }
            return true;
        } else if (c == '|') {
            int unmatch = 0;
            int left = 2, right = 3;
            while (right < expression.length()) {
                char cur = expression.charAt(right);
                if (cur == '(') {
                    unmatch++;
                }
                if (cur == ')') {
                    unmatch--;
                }
                if (unmatch < 0 || (cur == ',' && unmatch == 0)) {
                    if (parseBoolExpr(expression.substring(left, right))) {
                        return true;
                    }
                    left = right + 1;
                }
                right++;
            }
            return false;
        }
        return false;
    }
}