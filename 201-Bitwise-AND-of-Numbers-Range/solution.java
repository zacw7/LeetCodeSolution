class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = m & n;
        for (int i = 1; i <= 32; i++) {
            if (n - m >= (1 << i)) {
                res &= ~(1 << i);
            }
        }
        return res;
    }
}