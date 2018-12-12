class Solution {
    public int[] diStringMatch(String S) {
        int len = S.length();
        int min = 0, max = len;
        int[] ans = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if('I' == S.charAt(i)) {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        ans[len] = min;
        return ans;
    }
}