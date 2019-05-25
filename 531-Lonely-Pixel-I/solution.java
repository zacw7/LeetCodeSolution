class Solution {
    // TC: O(MN)
    // SC: O(M+N)
    public int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0] == null || picture[0].length == 0) {
            return 0;
        }
        int R = picture.length, C = picture[0].length;
        int[] blackRow = new int[R], blackCol = new int[C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (picture[r][c] == 'B') {
                    blackRow[r]++;
                    blackCol[c]++;
                }
            }
        }
        int pixels = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (picture[r][c] == 'B' && blackRow[r] == 1 && blackCol[c] == 1) {
                    pixels++;
                }
            }
        }
        return pixels;
    }
}