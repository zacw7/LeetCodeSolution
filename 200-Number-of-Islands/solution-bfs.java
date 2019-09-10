class Solution {
    // bfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int R = grid.length;
        int C = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    Queue<Integer> queue = new LinkedList();
                    grid[r][c] = '0';
                    queue.offer(r * C + c);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (int[] d : dirs) {
                            int n_r = cur / C + d[0], n_c = cur % C + d[1];
                            if (n_r >= 0 && n_c >= 0 && n_r < R && n_c < C && grid[n_r][n_c] == '1') {
                                grid[n_r][n_c] = '0';
                                queue.offer(n_r * C + n_c);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}