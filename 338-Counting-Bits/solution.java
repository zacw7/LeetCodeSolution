class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) ans[i] = ans[i - 1] + 1;
            else ans[i] = ans[i>>1];
        }
        return ans;
    }
}