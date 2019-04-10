class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        for (int i = T.length - 1; i >= 0; i--) {
            next[T[i]] = i;
            ans[i] = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; t++) {
                if (next[t] > 0) ans[i] = Math.min(ans[i], next[t] - i);
            }
            if (ans[i] == Integer.MAX_VALUE) ans[i] = 0;
        }
        return ans;
    }
}