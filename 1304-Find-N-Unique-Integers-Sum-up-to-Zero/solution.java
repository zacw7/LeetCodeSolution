class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i * 2 + 1 < n; i++) {
            ans[i * 2] = i + 1;
            ans[i * 2 + 1] = -ans[i * 2];
        }
        return ans;
    }
}