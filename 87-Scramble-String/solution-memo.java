class Solution {
    Map<String, Boolean> cache = new HashMap();
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + "/" + s2;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int N = s1.length();
        boolean res = false;
        for (int i = 1; i < N; i++) {
            String substrL1 = s1.substring(0, i), substrL2 = s2.substring(0, i);
            String substrR1 = s1.substring(i, N), substrR2 = s2.substring(i, N);
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i, N), s2.substring(i, N))) {
                res = true;
                break;
            }
            if (isScramble(s1.substring(0, i), s2.substring(N - i, N))
                    && isScramble(s2.substring(0, N - i), s1.substring(i, N))) {
                res = true;
                break;
            }
        }
        cache.put(key, res);
        return res;
    }
}