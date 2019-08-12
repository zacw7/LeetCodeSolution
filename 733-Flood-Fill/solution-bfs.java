class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0 || image[sr][sc] == newColor) {
            return image;
        }
        int R = image.length, C = image[0].length;
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<Integer> queue = new LinkedList();
        queue.offer(sr * C + sc);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            for (int[] d : dir) {
                int r = pos / C + d[0], c = pos % C + d[1];
                if (r >= 0 && c >= 0 && r < R && c < C && image[r][c] == oldColor) {
                    image[r][c] = newColor;
                    queue.offer(r * C + c);
                }
            }
        }
        return image;
    }
}