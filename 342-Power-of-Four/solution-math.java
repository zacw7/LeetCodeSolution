class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        // 0x0101 -> 5, 0x55555555
        return (0x55555555 & num) > 0 && ((num - 1) & num) == 0;
    }
}