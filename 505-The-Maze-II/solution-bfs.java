class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        R = maze.length;
        C = maze[0].length;
        int[][] minDist = new int[R][C];
        for (int[] d : minDist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Queue<State> queue = new LinkedList();
        queue.offer(new State(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.dist >= minDist[state.r][state.c]) {
                continue;
            }
            minDist[state.r][state.c] = state.dist;
            for (int i = 0; i < dirs.length; i++) {
                queue.offer(move(maze, state, dirs[i]));
            }
        }
        return minDist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : minDist[destination[0]][destination[1]];
    }

    private State move(int[][] maze, State old, int[] d) {
        int r = old.r, c = old.c, dist = old.dist;
        while (r + d[0] >= 0 && r + d[0] < R && c + d[1] >= 0 && c + d[1] < C && maze[r + d[0]][c + d[1]] == 0) {
            r += d[0];
            c += d[1];
            dist++;
        }
        return new State(r, c, dist);
    }

    class State {
        int r, c, dist;

        State(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}