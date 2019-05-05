class Solution {
    // DSU - with compressed find
    // Time: O(nlogn)
    // Space: O(n)
    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }
        if (edges == null || edges.length == 0) {
            return n;
        }

        DSU dsu = new DSU(n);
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
        }

        Set<Integer> components = new HashSet();
        for (int i = 0; i < n; i++) {
            components.add(dsu.find(i));
        }

        return components.size();
    }

    class DSU {
        int[] parents;

        DSU(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                parents[p_x] = p_y;
            }
        }

        int find(int x) {
            // with compression
            int p = parents[x];
            while (p != parents[p]) {
                p = parents[p];
            }
            while (x != parents[x]) {
                int tmp = parents[x];
                parents[x] = p;
                x = tmp;
            }
            return p;
        }
    }
}