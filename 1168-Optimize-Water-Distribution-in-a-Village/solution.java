class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i + 1, wells[i]});
        }
        for (int[] p : pipes) {
            pq.offer(p);
        }
        int cost = 0;
        DSU dsu = new DSU(n + 1);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dsu.find(cur[0]) != dsu.find(cur[1])) {
                dsu.union(cur[0], cur[1]);
                cost += cur[2];
            }
        }
        return cost;
    }

    class DSU {
        int[] parent, rank;

        DSU(int N) {
            this.parent = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] > rank[p_y]) {
                    parent[p_y] = p_x;
                } else if (rank[p_x] < rank[p_y]) {
                    parent[p_x] = p_y;
                } else {
                    parent[p_x] = p_y;
                    rank[p_y]++;
                }
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}