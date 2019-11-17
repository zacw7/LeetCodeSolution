class Solution {

    int R, C;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minPushBox(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        Queue<State> queue = new LinkedList();
        Set<String> visited = new HashSet();
        int[] player = new int[2];
        int[] box = new int[2];
        int[] target = new int[2];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 'S') {
                    player = new int[]{r, c};
                } else if (grid[r][c] == 'B') {
                    box = new int[]{r, c};
                } else if (grid[r][c] == 'T') {
                    target = new int[]{r, c};
                }
            }
        }
        State init = new State(player[0], player[1], box[0], box[1]);
        queue.offer(init);
        visited.add(init.toString());
        int push = 0;
        while (!queue.isEmpty()) {
            push++;
            int sz = queue.size();
            while (sz-- > 0) {
                State state = queue.poll();
                boolean[][] tmp = new boolean[R][C];
                tmp[state.p_r][state.p_c] = tmp[state.b_r][state.b_c] = true;
                dfs(grid, tmp, state.p_r, state.p_c);
                for (int[] d : dir) {
                    int r = state.b_r + d[0], c = state.b_c + d[1];
                    int t_r = state.b_r - d[0], t_c = state.b_c - d[1];
                    if (r >= 0 && c >= 0 && r < R && c < C
                            && t_r >= 0 && t_c >= 0 && t_r < R && t_c < C
                            && tmp[t_r][t_c] && grid[r][c] != '#') {
                        if (r == target[0] && c == target[1]) {
                            return push;
                        }
                        State neigh = new State(state.b_r, state.b_c, r, c);
                        if (!visited.contains(neigh.toString())) {
                            visited.add(neigh.toString());
                            queue.offer(neigh);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private void dfs(char[][] grid, boolean[][] tmp, int r0, int c0) {
        for (int[] d : dir) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && c >= 0 && r < R && c < C && grid[r][c] != '#' && !tmp[r][c]) {
                tmp[r][c] = true;
                dfs(grid, tmp, r, c);
            }
        }
    }

    class State {
        int p_r, p_c, b_r, b_c;

        State(int p_r, int p_c, int b_r, int b_c) {
            this.p_r = p_r;
            this.p_c = p_c;
            this.b_r = b_r;
            this.b_c = b_c;
        }

        @Override
        public String toString() {
            return p_r + "#" + p_c + "#" + b_r + "#" + b_c;
        }
    }
}