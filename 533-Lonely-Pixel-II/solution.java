class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture == null || picture.length == 0 || picture[0] == null || picture[0].length == 0) {
            return 0;
        }
        int R = picture.length, C = picture[0].length;
        int[] blackRow = new int[R], blackCol = new int[C];
        Map<String, List<Integer>> sameMap = new HashMap();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (picture[r][c] == 'B') {
                    blackRow[r]++;
                    blackCol[c]++;
                }
            }
            if (blackRow[r] == N) {
                String s = Arrays.toString(picture[r]);
                List<Integer> sameRow = sameMap.getOrDefault(s, new ArrayList());
                sameRow.add(r);
                sameMap.put(s, sameRow);
            }
        }
        int pixels = 0;
        for (List<Integer> sameRow : sameMap.values()) {
            if (sameRow.size() < N) {
                continue;
            }
            for (int r : sameRow) {
                for (int c = 0; c < C; c++) {
                    if (picture[r][c] == 'B' && blackCol[c] == N) {
                        pixels++;
                    }
                }
            }
        }
        return pixels;
    }
}