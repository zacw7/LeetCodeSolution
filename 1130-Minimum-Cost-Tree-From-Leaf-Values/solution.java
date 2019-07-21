class Solution {
    public int mctFromLeafValues(int[] arr) {
        return mctFromLeafValues(arr, 0, arr.length - 1).sum;
    }

    Map<Integer, Pair> cache = new HashMap();
    private Pair mctFromLeafValues(int[] arr, int s, int e) {
        int k = s * 40 + e;
        if (cache.containsKey(k)) {
            return cache.get(k);
        }
        Pair pair = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if (s > e) {
            pair = new Pair(0, 1);
        } if (s == e) {
            pair = new Pair(0, arr[s]);
        } else if (s + 1 == e) {
            pair = new Pair(arr[s] * arr[e], Math.max(arr[s], arr[e]));
        } else {
            for (int i = s; i < e; i++) {
                Pair left = mctFromLeafValues(arr, s, i);
                Pair right = mctFromLeafValues(arr, i + 1, e);
                int sum = left.sum + right.sum + left.leaf * right.leaf;
                int maxLeaf = Math.max(left.leaf, right.leaf);
                if (sum < pair.sum) {
                    pair.sum = sum;
                    pair.leaf = maxLeaf;
                }
            }
        }
        cache.put(k, pair);
        return pair;
    }

    class Pair {
        int sum, leaf;

        Pair(int sum, int leaf) {
            this.sum = sum;
            this.leaf = leaf;
        }
    }
}