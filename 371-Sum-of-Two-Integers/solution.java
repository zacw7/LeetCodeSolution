class Solution {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a < 0 && b < 0) {
            a &= Integer.MAX_VALUE;
            b &= Integer.MAX_VALUE;
        }
        int carry = a & b;
        int res = a ^ b;
        if (carry > 0) {
            res = getSum(res, carry << 1);
        }
        if (a < 0 && b < 0) {
            res |= (1 << 31);
        }
        return res;
    }
}