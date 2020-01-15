class Solution {
    char DEF = (char)('Z' + 1);
    public int minimumDistance(String word) {
        int N = word.length();
        if (N <= 2) {
            return 0;
        }
        int[][][] dp = new int[N][27][27];
        for (int[][] d : dp) {
            for (int[] r : d) {
                Arrays.fill(r, 3000);
            }
        }
        Map<Character, Pos> posMap = new HashMap();
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            posMap.put(c, new Pos(i / 6, i % 6));
        }
        dp[0][word.charAt(0) - 'A'][26] = 0;
        for (int i = 1; i < N; i++) {
            char c = word.charAt(i);
            for (char j = 'A'; j <= 'Z'; j++) {
                // move left only
                dp[i][c - 'A'][26] = Math.min(dp[i][c - 'A'][26], dp[i - 1][j - 'A'][26] + calDist(c, j, posMap));
                // move from right
                dp[i][j - 'A'][c - 'A'] = Math.min(dp[i][j - 'A'][c - 'A'], dp[i - 1][j - 'A'][26]);
                for (char k = 'A'; k <= 'Z'; k++) {
                    // move left
                    dp[i][c - 'A'][k - 'A'] = Math.min(dp[i][c - 'A'][k - 'A'], dp[i - 1][j - 'A'][k - 'A'] + calDist(c, j, posMap));
                    // move right
                    dp[i][j - 'A'][c - 'A'] = Math.min(dp[i][j - 'A'][c - 'A'], dp[i - 1][j - 'A'][k - 'A'] + calDist(c, k, posMap));
                }
            }
        }
        int res = 3000;
        for (int[] d : dp[N - 1]) {
            for (int dist : d) {
                res = Math.min(res, dist);
            }
        }
        return res;
    }

    private int calDist(char c1, char c2, Map<Character, Pos> posMap) {
        Pos p1 = posMap.get(c1), p2 = posMap.get(c2);
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "[" + x + " , " + y + "]";
        }
    }
}