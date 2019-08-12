class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length > 0
                && sr >= 0 && sr < image.length
                && sc >= 0 && sc < image[0].length
                && newColor != image[sr][sc]) {
            fill(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }

    private void fill(int[][] image, int r, int c, int newColor, int oldColor) {
        image[r][c] = newColor;
        if (r > 0 && image[r - 1][c] == oldColor) fill(image, r - 1, c, newColor, oldColor);
        if (r < image.length - 1 && image[r + 1][c] == oldColor) fill(image, r + 1, c, newColor, oldColor);
        if (c > 0 && image[r][c - 1] == oldColor) fill(image, r, c - 1, newColor, oldColor);
        if (c < image[0].length - 1 && image[r][c + 1] == oldColor) fill(image, r, c + 1, newColor, oldColor);
    }
}