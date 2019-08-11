class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        char[] chs = text.toCharArray();
        for (char c : chs) {
            count[c - 'a']++;
        }
        int max = 0;
        for (char sel = 'a'; sel <= 'z'; sel++) {
            if (count[sel - 'a'] <= max) {
                continue;
            }
            int l = 0, r = 1, cur = 1;
            int out = -1;
            if (chs[l] != sel) {
                out = l;
                cur = 0;
            }
            while (r < chs.length) {
                if (chs[r] == sel) {
                    cur++;
                } else {
                    if (out >= 0) {
                        cur -= out - l - 0;
                        l = out + 1;
                        out = r;
                    } else {
                        out = r;
                    }
                }
                if (out >= 0 && cur < count[sel - 'a']) {
                    max = Math.max(max, cur + 1);
                } else {
                    max = Math.max(max, cur);
                }
                r++;
            }
        }
        return max;
    }
}