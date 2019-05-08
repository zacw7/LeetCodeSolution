class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || (1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int[] used = new int[maxChoosableInteger + 1];
        return canWin(used, 0, desiredTotal);
    }

    private Map<String, Boolean> cache = new HashMap();
    private boolean canWin(int[] used, int cur, int desiredTotal) {
        String key = Arrays.toString(used);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean res = false;
        for (int i = used.length - 1; i > 0; i--) {
            if (used[i] == 0) {
                if (cur + i >= desiredTotal) {
                    res = true;
                } else {
                    used[i] = 1;
                    if (!canWin(used, cur + i, desiredTotal)) {
                        res = true;
                    }
                    used[i] = 0;
                }
                if (res) {
                    break;
                }
            }
        }
        cache.put(key, res);
        return res;
    }
}