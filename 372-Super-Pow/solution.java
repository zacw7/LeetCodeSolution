class Solution {
    public int superPow(int a, int[] b) {
        if (a == 0 || b == null || b.length == 0) {
            return 0;
        }
        if (a == 1 || (b.length == 1 && b[0] == 0)) {
            return 1;
        }
        int MOD = 1337;
        a %= MOD;
        int res = 1;
        int prev = 1, pow = a;
        for (int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b[i]; j++) {
                res *= pow;
                res %= MOD;
            }
            prev = pow;
            for (int j = 1; j < 10; j++) {
                pow *= prev;
                pow %= MOD;
            }
        }
        return res;
    }
}