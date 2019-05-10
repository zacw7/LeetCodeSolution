class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }
        int BLDG_ID = 0;
        int R = grid.length, C = grid[0].length;
        Queue<int[]> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    queue.add(new int[]{r, c, BLDG_ID++});
                }
            }
        }
        boolean[][][] visited = new boolean[R][C][BLDG_ID];
        int[][] distSums = new int[R][C];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int dist = 0, minDist = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            dist++;
            int s = queue.size();
            while (s-- > 0) {
                int[] cur = queue.poll();
                int id = cur[2];
                int r = cur[0], c = cur[1];
                visited[r][c][id] = true;
                for (int[] d : directions) {
                    r = cur[0] + d[0];
                    c = cur[1] + d[1];
                    if (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c][id] && grid[r][c] <= 0) {
                        visited[r][c][id] = true;
                        grid[r][c]--;
                        distSums[r][c] += dist;
                        queue.offer(new int[]{r, c, id});
                        if (grid[r][c] == -BLDG_ID) {
                            minDist = Math.min(minDist, distSums[r][c]);
                        }
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}