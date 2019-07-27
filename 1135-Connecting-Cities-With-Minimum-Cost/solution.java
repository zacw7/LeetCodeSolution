class Solution {
    public int minimumCost(int N, int[][] conections) {
        if (N <= 1) {
            return 0;
        }
        Arrays.sort(conections, (a, b) -> a[2] - b[2]);
        DSU dsu = new DSU(N + 1);
        int size = 1, cost = 0;
        for (int[] con : conections) {
            if (dsu.find(con[0]) != dsu.find(con[1])) {
                dsu.union(con[0], con[1]);
                cost += con[2];
                size++;
            }
            if (size >= N) {
                break;
            }
        }
        return size < N ? -1 : cost;
    }

    class Edge {
        int from, to, cost;

        Edge(int[] con) {
            this.from = con[0];
            this.to = con[1];
            this.cost = con[2];
        }
    }

    class DSU {
        int[] parent, rank;

        public DSU(int N) {
            parent = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] < rank[p_y]) {
                    parent[p_x] = p_y;
                } else if (rank[p_x] > rank[p_y]) {
                    parent[p_y] = p_x;
                } else {
                    parent[p_x] = p_y;
                    rank[p_y]++;
                }
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
    }
}