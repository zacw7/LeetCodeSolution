class Solution {
    Map<String, Integer> cache = new HashMap();
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        // make x >= y
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        String key = x + "/" + y;
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            cache.put(key, 10000000);
        }
        int res = Math.min(minKnightMoves(x - 1, y - 2), minKnightMoves(x - 2, y - 1)) + 1;
        cache.put(key, res);
        return res;
    }
}