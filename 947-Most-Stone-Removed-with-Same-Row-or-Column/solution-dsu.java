class Solution {
    // DSU
    // T: O(nlogn)
    // T: O(N)
    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        DSU dsu = new DSU(20000);
        for (int[] s : stones) {
            dsu.union(s[0], s[1] + 10000);
        }

        Set<Integer> groups = new HashSet();
        for (int[] s : stones) {
            groups.add(dsu.find(s[0]));
        }
        return stones.length - groups.size();
    }

    class DSU {
        private int[] parents;

        DSU(int capacity) {
            this.parents = new int[capacity];
            for (int i = 0; i < 20000; i++) {
                parents[i] = i;
            }
        }

        private void union(int x, int y) {
            int pX = find(x);
            int pY = find(y);
            if (pX != pY) {
                parents[pX] = pY;
            }
        }

        private int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }
            return x;
        }
    }
}