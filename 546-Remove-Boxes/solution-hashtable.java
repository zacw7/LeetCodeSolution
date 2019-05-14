class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        Map<Integer, Integer> cache = new HashMap();
        return dfs(boxes, 0, boxes.length - 1, 0, cache);
    }

    private int dfs(int[] boxes, int l, int r, int k, Map<Integer, Integer> cache) {
        if (l > r) {
            return 0;
        }
        int key = l * 10000 + r * 100 + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int value = 0;
        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        value = dfs(boxes, l, r - 1, 0, cache) + (k + 1) * (k + 1);
        for (int i = r - 1; i >= l; i--) {
            if (boxes[i] == boxes[r]) {
                value = Math.max(value,
                        dfs(boxes, l, i, k + 1, cache) + dfs(boxes, i + 1, r - 1, 0, cache));
            }
        }
        cache.put(key, value);
        return value;
    }
}