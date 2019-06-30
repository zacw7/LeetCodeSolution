class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > S.length()) {
            return 0;
        }
        char[] chs = S.toCharArray();
        int[] count = new int[26];
        int ans = 0;
        for (int i = 0; i < K; i++) {
            count[chs[i] - 'a']++;
        }
        if (isDistinct(count)) {
            ans++;
        }
        for (int i = K; i < chs.length; i++) {
            count[chs[i - K] - 'a']--;
            count[chs[i] - 'a']++;
            if (isDistinct(count)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isDistinct(int[] count) {
        for (int c : count) {
            if (c > 1) {
                return false;
            }
        }
        return true;
    }
}