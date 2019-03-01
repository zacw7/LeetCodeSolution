class Solution {
    public int findComplement(int num) {
        int leadingZeros = 0;
        int pass = num;
        for (int i = 1; i <= 32; i++, pass >>= 1) {
            if ((1 & pass) == 1) leadingZeros = 32 - i;
        }
        num = ~num;
        num <<= leadingZeros;
        num >>>= leadingZeros;
        return num;
    }
}