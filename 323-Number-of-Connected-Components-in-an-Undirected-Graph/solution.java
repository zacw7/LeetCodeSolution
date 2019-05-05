class Solution {
    // DSU
    // Time: O(n^2)
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
            while (x != parents[x]) {
                x = parents[x];
            }
            return x;
        }
    }
}