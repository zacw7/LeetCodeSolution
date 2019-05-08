class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> expressions = new ArrayList();
        if (num != null && num.length() > 0) {
            expressionHelper(num.toCharArray(), new StringBuilder(), 0, true, expressions, target);
        }
        return expressions;
    }

    private void expressionHelper(char[] chs, StringBuilder sb, int index, boolean canAppendNum, List<String> expressions, int target) {
        if (index == chs.length) {
            if (Character.isDigit(sb.charAt(sb.length() - 1)) && validateExpression(sb.toString(), target)) {
                expressions.add(sb.toString());
            }
        } else if (index == 0) {
            sb.append(chs[index]);
            expressionHelper(chs, sb, index + 1, chs[index] != '0', expressions, target);
        } else {
            if (canAppendNum) {
                canAppendNum = chs[index] != '0' || Character.isDigit(sb.charAt(sb.length() - 1));
                sb.append(chs[index]);
                expressionHelper(chs, sb, index + 1, canAppendNum, expressions, target);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (Character.isDigit(sb.charAt(sb.length() - 1))) {
                sb.append('+');
                expressionHelper(chs, sb, index, true, expressions, target);
                sb.deleteCharAt(sb.length() - 1);
                sb.append('-');
                expressionHelper(chs, sb, index, true, expressions, target);
                sb.deleteCharAt(sb.length() - 1);
                sb.append('*');
                expressionHelper(chs, sb, index, true, expressions, target);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean validateExpression(String expr, int target) {
        char sign = '+';
        long res = 0, prev = 0;
        for (int i = 0; i < expr.length(); i++) {
            long num = 0;
            while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                num *= 10;
                num += expr.charAt(i) - '0';
                i++;
            }
            if (sign == '*') {
                prev *= num;
            } else if (sign == '+') { // '+' or '-'
                res += prev;
                prev = num;
            } else if (sign == '-') {
                res += prev;
                prev = -num;
            }
            if (i < expr.length()) {
                sign = expr.charAt(i);
            }
        }
        res += prev;
        return res == target;
    }
}