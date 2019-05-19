class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1, diff = k; i < n; i++) {
            if (k == 0) {
                ans[i] = i + 1;
            } else {
                if (i % 2 == 0) {
                    ans[i] = ans[i - 1] - k;
                } else {
                    ans[i] = ans[i - 1] + k;
                }
                k--;
            }
        }
        return ans;
    }
}