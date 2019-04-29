class Solution {
    // BFS
    public int slidingPuzzle(int[][] board) {
        int TARGET = hash(new int[][]{{1, 2, 3}, {4, 5, 0}});
        Set<Integer> visited = new HashSet();
        Queue<int[][]> queue = new LinkedList();
        queue.offer(board);
        visited.add(hash(board));

        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[][] cur = queue.poll();
                if (hash(cur) == TARGET) {
                    return move;
                }
                int[] zero = findZero(cur);
                int r = zero[0], c = zero[1];
                // vertical swap
                swap(cur, r, c, 1 - r, c);
                if (!visited.contains(hash(cur))) {
                    visited.add(hash(cur));
                    int[][] next = new int[][]{cur[0].clone(), cur[1].clone()};
                    queue.offer(next);
                }
                swap(cur, r, c, 1 - r, c);

                // horizontal swap
                if (c > 0) {
                    swap(cur, r, c, r, c - 1);
                    if (!visited.contains(hash(cur))) {
                        visited.add(hash(cur));
                        int[][] next = new int[][]{cur[0].clone(), cur[1].clone()};
                        queue.offer(next);
                    }
                    swap(cur, r, c, r, c - 1);
                }
                if (c < 2) {
                    swap(cur, r, c, r, c + 1);
                    if (!visited.contains(hash(cur))) {
                        visited.add(hash(cur));
                        int[][] next = new int[][]{cur[0].clone(), cur[1].clone()};
                        queue.offer(next);
                    }
                    swap(cur, r, c, r, c + 1);
                }
            }
            move++;
        }

        return -1;
    }

    private int[] findZero(int[][] board) {
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 0) {
                    return new int[]{r, c};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private int hash(int[][] board) {
        return board[0][0] * 1 + board[0][1] * 10 + board[0][2] * 100
                + board[1][0] * 1000 + board[1][1] * 10000  + board[1][2] * 100000;
    }

    private void swap(int[][] board, int r1, int c1, int r2, int c2) {
        int tmp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = tmp;
    }
}