class Solution {
    // TLE
    public int findPaths(int m, int n, int N, int i, int j) {
        if (m == 0 || n == 0) return 0;
        int[] ans = {0};
        dfs(m, n, N, i, j, ans);
        return ans[0];
    }

    private void dfs(int m, int n, int N, int i, int j, int[] ans) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            ans[0]++;
            return;
        }
        if (N > 0) {
            dfs(m, n, N - 1, i - 1, j, ans);
            dfs(m, n, N - 1, i + 1, j, ans);
            dfs(m, n, N - 1, i, j + 1, ans);
            dfs(m, n, N - 1, i, j - 1, ans);
        }
    }
}