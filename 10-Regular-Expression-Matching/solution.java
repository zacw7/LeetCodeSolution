class Solution {
    // DFS
    public boolean isMatch(String s, String p) {
        if (p == null || s == null) {
            return false;
        }
        return matchHelper(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean matchHelper(char[] s, int idx_S, char[] p, int idx_P) {
        if (idx_S == s.length) {
            while (idx_P < p.length) {
                if (idx_P + 1 < p.length && p[idx_P + 1] == '*') {
                    idx_P += 2;
                } else {
                    return false;
                }
            }
            return true;
        } else if (idx_P == p.length) {
            return false;
        } else if (idx_P + 1 < p.length && p[idx_P + 1] == '*') {
            if (matchHelper(s, idx_S, p, idx_P + 2)) {
                return true;
            }
            if (p[idx_P] == '.') {
                for (int i = idx_S; i < s.length; i++) {
                    if (matchHelper(s, i + 1, p, idx_P + 2)) {
                        return true;
                    }
                }
            } else {
                for (int i = idx_S; i < s.length && p[idx_P] == s[i]; i++) {
                    if (matchHelper(s, i + 1, p, idx_P + 2)) {
                        return true;
                    }
                }
            }
        } else if (p[idx_P] == s[idx_S] || p[idx_P] == '.') {
            return matchHelper(s, idx_S + 1, p, idx_P + 1);
        }
        return false;
    }
}