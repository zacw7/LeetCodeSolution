class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                left--;
            }
            if (left < 0) {
                right++;
                left = 0;
            }
        }
        List<String> res = new ArrayList();
        dfs(s, 0, left, right, res);
        return res;
    }

    private void dfs(String s, int index, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        if (right > 0) {
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == ')' && (i == 0 || s.charAt(i - 1) != ')')) {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, res);
                }
            }
        } else {
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == '(' && (i == 0 || s.charAt(i - 1) != '(')) {
                    dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, res);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int unbalanced = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                unbalanced++;
            } else if (c == ')') {
                unbalanced--;
            }
            if (unbalanced < 0) {
                return false;
            }
        }
        return unbalanced == 0;
    }
}