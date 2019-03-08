class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int offset = 1;

        while (offset <= s.length() / 2) {
            if (s.length() % offset > 0) {
                offset++;
                continue;
            }
            boolean flag = true;
            int groups = s.length() / offset;
            for (int i = 0; i < offset; i++) {
                char ch = s.charAt(i);
                for (int j = 1; j < groups; j++) {
                    if (ch != s.charAt(i + j * offset)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) return true;
            else offset++;
        }
        return false;
    }
}