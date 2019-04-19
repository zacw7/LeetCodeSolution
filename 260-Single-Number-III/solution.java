class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        int mask = 1;
        while ((mask & xor) == 0) {
            mask <<= 1;
        }
        for (int n : nums) {
            if ((n & mask) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }

        return res;
    }
}