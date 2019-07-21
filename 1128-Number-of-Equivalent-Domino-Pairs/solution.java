class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[][] count = new int[10][10];
        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            ans += count[a][b];
            count[a][b]++;
        }
        return ans;
    }
}