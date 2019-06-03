class Solution {
    public String decodeString(String s) {
        return dfs(s, 0, 1);
    }

    private String dfs(String s, int index, int num) {
        StringBuilder sb = new StringBuilder();
        int brackets = 0;
        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9' && brackets == 0) {
                // look for '['
                int tmp = i;
                while (s.charAt(i) != '[') i++;
                int n = Integer.valueOf(s.substring(tmp, i));
                sb.append(dfs(s, i + 1, n));
                brackets++;
            } else if (ch == '[') brackets++;
            else if (ch == ']') brackets--;
            else if (brackets == 0) sb.append(ch);
            else if (brackets < 0) break;
        }
        StringBuilder res = new StringBuilder();
        while (num-- > 0) res.append(sb);
        return res.toString();
    }
}