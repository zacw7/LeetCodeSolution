class Solution {
    public int shortestPath(int[][] grid, int k) {
        int R = grid.length, C = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int blocks = 0;
        int[][][] visited = new int[R][C][k + 1];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                Arrays.fill(visited[r][c], Integer.MAX_VALUE);
                if (grid[r][c] == 1) {
                    blocks++;
                }
            }
        }
        if (k >= blocks) {
            return R + C - 2;
        }
        Arrays.fill(visited[0][0], 0);
        PriorityQueue<State> pq = new PriorityQueue<State>((a, b) -> a.s - b.s);
        pq.offer(new State(0, 0, k, 0));
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            for (int[] d : dirs) {
                int r = cur.r + d[0];
                int c = cur.c + d[1];
                int curK = cur.k;
                int curS = cur.s + 1;
                if (r >= 0 && c >= 0 && r < R && c < C) {
                    if (grid[r][c] == 1) {
                        if (curK > 0) {
                            curK--;
                        } else {
                            continue;
                        }
                    }
                    if (r == R - 1 && c == C - 1) {
                        return curS;
                    }
                    State neigh = new State(r, c, curK, curS);
                    if (visited[r][c][curK] > curS) {
                        for (int i = curK; i >= 0 && visited[r][c][i] > curS; i--) {
                            visited[r][c][i] = curS;
                        }
                        pq.offer(neigh);
                    }
                }
            }
        }
        return -1;
    }

    class State {
        int r, c, k, s;

        State(int r, int c, int k, int s) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.s = s;
        }
    }
}