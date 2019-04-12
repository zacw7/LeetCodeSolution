class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // trim the prefix ')'
        s = s.replaceAll("^\\)+", "");
        Set<String> ans = new HashSet();
        int misMatchL = 0, misMatchR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') misMatchL++;
            else if (s.charAt(i) == ')') {
                if (misMatchL == 0) misMatchR++;
                else misMatchL--;
            }
        }
        helper(new StringBuilder(s), 0, misMatchL, misMatchR, ans);
        return new ArrayList(ans);
    }

    private void helper(StringBuilder sb, int index, int left, int right, Set<String> ans) {
        if (left == 0 && right == 0) {
            String s = sb.toString();
            if (isValid(s)) ans.add(s);
            return;
        }
        if (index == sb.length()) return;
        char ch = sb.charAt(index);
        if (ch == '(' && left > 0) {
            sb.deleteCharAt(index);
            helper(sb, index, left - 1, right, ans);
            sb.insert(index, '(');
        } else if (ch == ')' && right > 0) {
            sb.deleteCharAt(index);
            helper(sb, index, left, right - 1, ans);
            sb.insert(index, ')');
        }
        helper(sb, index + 1, left, right, ans);
    }

    private boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') left--;
            if (left < 0) return false;
        }
        return left == 0;
    }
}