class Solution {
    public int hammingDistance(int x, int y) {
        int distance = 0, xor = x ^ y;
        for (int i = 0; i < 32; i++, xor = (xor >> 1)) {
            if ((xor & 1) > 0) distance++;
        }
        return distance;
    }
}