class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int N = arr.length;
        int[] prefix = new int[N];
        prefix[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < ans.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l == r) {
                ans[i] = arr[l];
            } else if (l == 0) {
                ans[i] = prefix[r];
            } else {
                ans[i] = prefix[r] ^ prefix[l - 1];
            }
        }
        return ans;
    }
}