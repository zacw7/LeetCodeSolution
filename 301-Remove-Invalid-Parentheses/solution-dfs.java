class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) {
                    right++;
                } else {
                    open--;
                }
            }
        }
        left = open;
        List<String> res = new ArrayList();
        dfs(s, 0, left, right, 0, new StringBuilder(), res);
        return res;
    }

    private void dfs(String s, int index, int left, int right, int open, StringBuilder sb, List<String> res) {
        if (index == s.length()) {
            if (open == 0) {
                res.add(sb.toString());
            }
            return;
        }
        if (open < 0) {
            return;
        }
        char c = s.charAt(index);
        if (c == '(') {
            if (left > 0 && (sb.length() == 0 || sb.charAt(sb.length() - 1) != '(')) {
                dfs(s, index + 1, left - 1, right, open, sb, res);
            }
            sb.append(c);
            dfs(s, index + 1, left, right, open + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else if (c == ')') {
            if (right > 0 && (sb.length() == 0 || sb.charAt(sb.length() - 1) != ')')) {
                dfs(s, index + 1, left, right - 1, open, sb, res);
            }
            sb.append(c);
            dfs(s, index + 1, left, right, open - 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(c);
            dfs(s, index + 1, left, right, open, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}