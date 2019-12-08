class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int minFlips(int[][] mat) {
        R = mat.length;
        C = mat[0].length;
        if (allZeroMat(mat)) {
            return 0;
        }
        Set<String> seen = new HashSet();
        Queue<int[][]> queue = new LinkedList();
        seen.add(hashMat(mat));
        queue.offer(mat);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int sz = queue.size();
            while (sz-- > 0) {
                int[][] cur = queue.poll();
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        int[][] tmp = cloneMat(cur);
                        reverse(tmp, r, c);
                        if (allZeroMat(tmp)) {
                            return steps;
                        }
                        String key = hashMat(tmp);
                        if (!seen.contains(key)) {
                            seen.add(key);
                            queue.offer(tmp);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private void reverse(int[][] mat, int r0, int c0) {
        mat[r0][c0] = 1 - mat[r0][c0];
        for (int[] d : dirs) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && c >= 0 && r < R && c < C) {
                mat[r][c] = 1 - mat[r][c];
            }
        }
    }

    private String hashMat(int[][] mat) {
        String res = "x\n";
        for (int[] m : mat) {
            res += Arrays.toString(m)+"\n";
        }
        return res;
    }

    private int[][] cloneMat(int[][] mat) {
        int[][] res = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                res[r][c] = mat[r][c];
            }
        }
        return res;
    }

    private boolean allZeroMat(int[][] mat) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (mat[r][c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}