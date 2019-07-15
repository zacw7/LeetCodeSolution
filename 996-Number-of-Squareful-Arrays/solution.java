class Solution {
    int ans = 0;
    public int numSquarefulPerms(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }
        Arrays.sort(A);
        boolean[] used = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }
            used[i] = true;
            dfs(A, A[i], 1, used);
            used[i] = false;
        }
        return ans;
    }

    private void dfs(int[] A, int prev, int index, boolean[] used) {
        if (index == A.length) {
            ans++;
            return;
        }
        for (int i = 0; i < A.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && A[i] == A[i - 1]) || !isSquareful(prev + A[i])) {
                continue;
            }
            used[i] = true;
            dfs(A, A[i], index + 1, used);
            used[i] = false;
        }
    }

    private boolean isSquareful(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }
}