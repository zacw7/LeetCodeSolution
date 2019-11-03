class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                } else {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        if (open == 0) {
            return sb.toString();
        } else {
            open = 0;
            s = sb.toString();
            sb = new StringBuilder();
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                open++;
                sb.append(c);
            } else if (c == '(') {
                if (open == 0) {
                    continue;
                } else {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        sb.reverse();
        return sb.toString();
    }
}