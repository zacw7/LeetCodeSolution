class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null) {
            return 0;
        }
        return longestPalindromeSubseq(s, 0, s.length() - 1);
    }

    private Map<Integer, Integer> cache = new HashMap();
    private int longestPalindromeSubseq(String s, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 1;
        }
        int key = l * 1000 + r;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res = 0;
        if (s.charAt(l) == s.charAt(r)) {
            res = 2 + longestPalindromeSubseq(s, l + 1, r - 1);
        } else {
            res = Math.max(longestPalindromeSubseq(s, l + 1, r), longestPalindromeSubseq(s, l, r - 1));
        }
        cache.put(key, res);
        return res;
    }
}