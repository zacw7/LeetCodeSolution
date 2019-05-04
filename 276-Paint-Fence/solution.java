class Solution {
    public int numWays(int n, int k) {
        if ((n == 0) || k == 1 && n > 2) {
            return 0;
        }
        int ways = k;
        int same = k, diff = k * (k - 1);
        for (int i = 2; i <= n; i++) {
            ways = same + diff;
            int tmpDiff = diff;
            diff = same * (k - 1) + diff * (k - 1);
            same = tmpDiff;
        }
        return ways;
    }
}