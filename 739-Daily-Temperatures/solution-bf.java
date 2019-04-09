class Solution {
    public int[] dailyTemperatures(int[] T) {
        int ans[] = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }
}