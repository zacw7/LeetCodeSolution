class Solution {
    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1);
        while (xor > 0) {
            if ((xor & 1) == 0) {
                return false;
            }
            xor >>= 1;
        }
        return true;
    }
}