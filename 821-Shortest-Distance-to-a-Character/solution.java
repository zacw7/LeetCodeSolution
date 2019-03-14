class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] ans = new int[S.length()];
        for (int i = 0; i < ans.length; i++) {
            if (S.charAt(i) == C) {
                ans[i] = 0;
                for (int j = i - 1; j >= 0 && ans[j] > i - j; j--) ans[j] = i - j;
            } else if (i > 0 && ans[i - 1] < Integer.MAX_VALUE) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}