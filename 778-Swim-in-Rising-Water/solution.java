class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;
        int t = grid[0][0];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            t = Math.max(t, grid[pos[0]][pos[1]]);
            for (int[] d : dirs) {
                int r = pos[0] + d[0], c = pos[1] + d[1];
                if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
                    if (r == N - 1 && c == N - 1) {
                        return Math.max(t, grid[r][c]);
                    }
                    visited[r][c] = true;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        return t;
    }
}