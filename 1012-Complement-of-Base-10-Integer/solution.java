class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int highestBit = Integer.highestOneBit(N);
        int mask = 0;
        while (highestBit > 0) {
            mask |= highestBit;
            highestBit >>= 1;
        }
        return ~N & mask;
    }
}