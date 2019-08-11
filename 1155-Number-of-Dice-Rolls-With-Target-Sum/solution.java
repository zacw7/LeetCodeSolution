class Solution {
    int MOD = 1_000_000_007;
    Map<Integer, Integer> cache = new HashMap();
    public int numRollsToTarget(int d, int f, int target) {
        if (d == 0 || target <= 0) {
            return 0;
        }
        if (d == 1 && target > 0 && target <= f) {
            return 1;
        }
        int key = d * 1001 + target;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            res += numRollsToTarget(d - 1, f, target - i);
            res %= MOD;
        }
        cache.put(key, res);
        return res;
    }
}