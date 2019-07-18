class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        R = maze.length;
        C = maze[0].length;
        return dfs(maze, start, destination, new boolean[R][C]);
    }

    private boolean dfs(int[][] maze, int[] pos, int[] destination, boolean[][] visited) {
        int r = pos[0], c = pos[1];
        if (visited[r][c]) {
            return false;
        }
        if (r == destination[0] && c == destination[1]) {
            return true;
        }
        visited[r][c] = true;
        for (int i = 0; i < dirs.length; i++) {
            if (dfs(maze, move(maze, pos, i), destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private int[] move(int[][] maze, int[] pos, int i) {
        int r = pos[0], c = pos[1];
        int[] d = dirs[i];
        while (r + d[0] >= 0 && r + d[0] < R && c + d[1] >= 0 && c + d[1] < C && maze[r + d[0]][c + d[1]] == 0) {
            r += d[0];
            c += d[1];
        }
        return new int[]{r, c};
    }
}