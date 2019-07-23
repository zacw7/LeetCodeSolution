class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        boolean[] visited = new boolean[N * N + 1];
        Queue<Integer> queue = new LinkedList();
        visited[1] = true;
        queue.offer(1);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int[] curPos = positionHelper(cur, N);
                for (int i = 1; cur + i <= N * N && i <= 6; i++) {
                    int next = cur + i;
                    if (next == N * N) {
                        return step;
                    }
                    int[] nextPos = positionHelper(next, N);
                    if (board[nextPos[0]][nextPos[1]] > 0) {
                        next = board[nextPos[0]][nextPos[1]];
                    }
                    if (next == N * N) {
                        return step;
                    } else if (visited[next]) {
                        continue;
                    } else {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int[] positionHelper(int num, int N) {
        num -= 1;
        int r = num / N, c = num % N;
        if (r % 2 == 1) {
            c = N - c - 1;
        }
        return new int[]{N - r - 1, c};
    }
}