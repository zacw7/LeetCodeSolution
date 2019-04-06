class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean helper(char[] source, char[] pattern, int is, int ip) {
        if (is == source.length) {
            if (ip < pattern.length) {
                if (pattern[ip] == '*') return helper(source, pattern, is, ip + 1);
                else return false;
            }
            else return true;
        }
        if (ip == pattern.length) return false;

        if (pattern[ip] == '?' || pattern[ip] == source[is]) {
            return helper(source, pattern, is + 1, ip + 1);
        } else if (pattern[ip] == '*') {
            for (int i = is; i <= source.length; i++) {
                if (helper(source, pattern, i, ip + 1)) return true;
            }
        }
        return false;
    }
}