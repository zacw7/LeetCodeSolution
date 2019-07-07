class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        char[] chs = seq.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chs.length - 1; i++) {
            if (chs[i] == '(' && chs[i + 1] == '(' && !flag) {
                ans[i] = 1;
                flag = true;
            }
            if (chs[i] == ')' && chs[i + 1] == ')' && flag) {
                ans[i] = 1;
                flag = false;
            }
        }
        return ans;
    }
}