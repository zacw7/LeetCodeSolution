class Solution {
    int R, C;
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        R = maze.length;
        C = maze[0].length;
        Map<String, int[]> dirs = new HashMap();
        dirs.put("u", new int[]{-1, 0});
        dirs.put("d", new int[]{1, 0});
        dirs.put("l", new int[]{0, -1});
        dirs.put("r", new int[]{0, 1});
        State[][] st = new State[R][C];
        Queue<State> queue = new LinkedList();
        queue.offer(new State(ball[0], ball[1], 0, ""));
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (st[cur.r][cur.c] != null) {
                if (cur.dist > st[cur.r][cur.c].dist
                        || (cur.dist == st[cur.r][cur.c].dist && cur.path.compareTo(st[cur.r][cur.c].path) >= 0)) {
                    continue;
                }
            }
            st[cur.r][cur.c] = cur;
            if (cur.r == hole[0] && cur.c == hole[1]) {
                continue;
            }
            for (String d : dirs.keySet()) {
                State next = new State(cur.r, cur.c, cur.dist, cur.path + d);
                if (move(maze, next, dirs.get(d), hole)) {
                    queue.offer(next);
                }
            }
        }
        return st[hole[0]][hole[1]] == null ? "impossible" : st[hole[0]][hole[1]].path;
    }

    private boolean move(int[][] maze, State state, int[] d, int[] hole) {
        int r = state.r, c = state.c;
        while (state.r + d[0] >= 0
                && state.r + d[0] < R
                && state.c + d[1] >= 0
                && state.c + d[1] < C
                && maze[state.r + d[0]][state.c + d[1]] == 0) {
            state.r += d[0];
            state.c += d[1];
            state.dist++;
            if (state.r == hole[0] && state.c == hole[1]) {
                break;
            }
        }
        return r != state.r || c != state.c;
    }

    class State {
        int r, c, dist;
        String path;

        State(int r, int c, int dist, String path) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.path = path;
        }

        @Override
        public String toString() {
            return "(" + r + " / " + c + " d: " + dist + " p: " + path + ")";
        }
    }
}