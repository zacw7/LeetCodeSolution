class Solution {
    private Map<Integer, Integer> cache = new HashMap();
    public int integerReplacement(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int res = 0;
        if (n > 1) {
            res = 1;
            if (n % 2 == 0) {
                // even
                res += integerReplacement(n / 2);
            } else {
                // odd
                if (n == Integer.MAX_VALUE) {
                    res += Math.min(integerReplacement(n - 1), 1 + integerReplacement(1073741824));
                } else {
                    res += Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
                }
            }
        }
        cache.put(n, res);
        return res;
    }
}