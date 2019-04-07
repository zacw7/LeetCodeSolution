class Solution {
    public int findCircleNum(int[][] M) {
        int count = 0;
        Set<Integer> seen = new HashSet();
        for (int n = 0; n < M.length; n++) {
            if (!seen.contains(n)) {
                count++;
                dfs(M, n, seen);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int n, Set<Integer> seen) {
        seen.add(n);
        for (int i = 0; i < M.length; i++) {
            if (M[n][i] == 1 && !seen.contains(i)) dfs(M, i, seen);
        }
    }
}