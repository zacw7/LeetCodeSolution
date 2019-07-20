class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                dsu.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!' && dsu.find(eq.charAt(0) - 'a') == dsu.find(eq.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    class DSU {
        int[] parents, rank;
        DSU() {
            int N = 26;
            this.parents = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] > rank[p_y]) {
                    parents[p_y] = p_x;
                } else if (rank[p_x] < rank[p_y]) {
                    parents[p_x] = p_y;
                } else {
                    parents[p_y] = p_x;
                    rank[p_x]++;
                }
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
}