class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while (a > 0 || b > 0 || c > 0) {
            int target = c & 1;
            if (target == 0) {
                if ((a & 1) == 1) {
                    res++;
                }
                if ((b & 1) == 1) {
                    res++;
                }
            } else {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    res++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return res;
    }
}