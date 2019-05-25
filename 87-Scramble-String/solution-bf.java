class Solution {
    // DFS [TLE]
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Set<String> scrambleStrs = scrambleHelper(s1);
        return scrambleStrs.contains(s2);
    }

    private Set<String> scrambleHelper(String s) {
        Set<String> res = new HashSet();
        res.add(s);
        if (s.length() <= 1) {
            return res;
        }
        for (int i = 1; i < s.length(); i++) {
            Set<String> subset1 = scrambleHelper(s.substring(0, i));
            Set<String> subset2 = scrambleHelper(s.substring(i));
            for (String s1 : subset1) {
                for (String s2 : subset2) {
                    res.add(s1 + s2);
                    res.add(s2 + s1);
                }
            }
        }
        return res;
    }
}