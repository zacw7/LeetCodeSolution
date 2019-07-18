class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        R = maze.length;
        C = maze[0].length;
        int[][] dist = new int[R][C];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dfs(maze, start[0], start[1], 0, dist);
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    private void dfs(int[][] maze, int r, int c, int curDist, int[][] dist) {
        if (curDist >= dist[r][c]) {
            return;
        }
        dist[r][c] = curDist;
        for (int i = 0; i < dirs.length; i++) {
            int[] m = move(maze, r, c, dirs[i]);
            dfs(maze, m[0], m[1], curDist + m[2], dist);
        }
    }

    private int[] move(int[][] maze, int r, int c, int[] d) {
        int count = 0;
        while (r + d[0] >= 0 && r + d[0] < R && c + d[1] >= 0 && c + d[1] < C && maze[r + d[0]][c + d[1]] == 0) {
            r += d[0];
            c += d[1];
            count++;
        }
        return new int[]{r, c, count};
    }
}