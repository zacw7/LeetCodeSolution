class Solution {
    // DSU
    // Time: O(klogmn)
    // Space: O(k)
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DSU dsu = new DSU(m * n);
        int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] grid = new int[m][n];
        List<Integer> nums = new ArrayList();
        for (int[] p : positions) {
            if (grid[p[0]][p[1]] == 0) {
                grid[p[0]][p[1]] = 1;
                dsu.groups++;
                for (int[] DIR : DIRECTIONS) {
                    int x = p[0] + DIR[0], y = p[1] + DIR[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        dsu.union(p[0] * n + p[1], x * n + y);
                    }
                }
            }
            nums.add(dsu.groups);
        }
        return nums;
    }

    class DSU {
        int[] parents;
        int groups = 0;

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
                groups--;
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