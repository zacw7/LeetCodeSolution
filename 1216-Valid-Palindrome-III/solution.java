class Solution {
    public boolean isValidPalindrome(String s, int k) {
        if (s.length() <= k + 1) {
            return true;
        }
        return isValidPalindrome(s, k, 0, s.length() - 1);
    }

    Map<String, Integer> cache = new HashMap();
    private boolean isValidPalindrome(String s, int k, int l, int r) {
        String key = l + "/" + r;
        if (cache.containsKey(key) && k <= cache.get(key)) {
            return false;
        }
        if (k < 0) {
            return false;
        }
        if (l >= r) {
            return true;
        }
        boolean res = false;
        if (s.charAt(l) == s.charAt(r)) {
            res = isValidPalindrome(s, k, l + 1, r - 1);
        } else {
            res = isValidPalindrome(s, k - 1, l + 1, r) || isValidPalindrome(s, k - 1, l, r - 1);
        }
        cache.put(key, k);
        return res;
    }
}