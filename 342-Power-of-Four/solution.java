class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        int dividor = (num > 0) ? 4 : -4;
        while (num > 1 || num < -1) {
            if (num % dividor != 0) return false;
            num /= 4;
        }
        return num == 1;
    }
}