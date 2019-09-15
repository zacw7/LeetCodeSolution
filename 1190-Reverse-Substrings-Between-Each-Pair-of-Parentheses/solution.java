class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<StringBuilder> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                // reverse cur
                String cur = reverse(sb.toString().toCharArray());
                sb = stack.pop();
                sb.append(cur);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String reverse(char[] chs) {
        int l = 0, r = chs.length - 1;
        while (l < r) {
            char tmp = chs[l];
            chs[l] = chs[r];
            chs[r] = tmp;
            l++;
            r--;
        }
        return new String(chs);
    }
}