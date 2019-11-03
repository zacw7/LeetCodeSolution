class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }
        int N = s1.length();
        int[] diff = new int[256];
        int count = 0;
        for (int i = 0; i < N; i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (a == b) {
                continue;
            }
            diff[a]++;
            count++;
        }
        if (count % 2 > 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < 256; i++) {
            if (diff[i] == 0) {
                continue;
            }
            if (diff[i] % 2 == 1) {
                diff[i]--;
                res++;
            }
            res += diff[i] / 2;
        }
        return res;
    }
}