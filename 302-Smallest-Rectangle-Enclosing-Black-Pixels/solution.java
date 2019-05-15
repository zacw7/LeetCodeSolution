class Solution {
    int R, C;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0) {
            return 0;
        }
        R = image.length;
        C = image[0].length;
        // bound: 0 upper bound, 1 lower bound, 2 left bound, 3 right bound
        int[] bounds = {R, 0, C, 0};
        dfs(image, x, y, new boolean[R][C], bounds);
        return (bounds[1] - bounds[0] + 1) * (bounds[3] - bounds[2] + 1);
    }

    private void dfs(char[][] image, int r0, int c0, boolean[][] visited, int[] bounds) {
        if (visited[r0][c0]) {
            return;
        }
        visited[r0][c0] = true;
        bounds[0] = Math.min(bounds[0], r0);
        bounds[1] = Math.max(bounds[1], r0);
        bounds[2] = Math.min(bounds[2], c0);
        bounds[3] = Math.max(bounds[3], c0);
        for (int[] d : directions) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && image[r][c] == '1') {
                dfs(image, r, c, visited, bounds);
            }
        }
    }
}