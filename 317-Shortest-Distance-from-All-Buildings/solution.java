class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int R = grid.length, C = grid[0].length;
        List<int[]> buildings = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    buildings.add(new int[]{r, c});
                }
            }
        }
        int[][] distSums = new int[R][C];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int minDist = Integer.MAX_VALUE;
        for (int[] b : buildings) {
            boolean[][] visited = new boolean[R][C];
            int dist = 0;
            Queue<int[]> queue = new LinkedList();
            queue.offer(b);
            while (!queue.isEmpty()) {
                dist++;
                int s = queue.size();
                while (s-- > 0) {
                    int[] cur = queue.poll();
                    int r = cur[0], c = cur[1];
                    visited[r][c] = true;
                    for (int[] d : directions) {
                        r = cur[0] + d[0];
                        c = cur[1] + d[1];
                        if (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c] && grid[r][c] <= 0) {
                            visited[r][c] = true;
                            grid[r][c]--;
                            distSums[r][c] += dist;
                            queue.offer(new int[]{r, c});
                            if (grid[r][c] == -buildings.size()) {
                                minDist = Math.min(minDist, distSums[r][c]);
                            }
                        }
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}