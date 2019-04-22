class Solution {
    // T: O(n)
    // S: O(1)
    public int knightDialer(int N) {
        if (N == 0) {
            return 0;
        }

        int[] keys = new int[10];
        Arrays.fill(keys, 1);
        int MODULO = 1000000000 + 7;
        while (N-- > 1) {
            int[] tmp = keys.clone();
            keys[0] = (tmp[4] + tmp[6]) % MODULO;
            keys[1] = (tmp[6] + tmp[8]) % MODULO;
            keys[2] = (tmp[7] + tmp[9]) % MODULO;
            keys[3] = (tmp[4] + tmp[8]) % MODULO;
            keys[4] = ((tmp[3] + tmp[9]) % MODULO + tmp[0]) % MODULO;
            keys[5] = 0;
            keys[6] = ((tmp[1] + tmp[7]) % MODULO + tmp[0]) % MODULO;
            keys[7] = (tmp[2] + tmp[6]) % MODULO;
            keys[8] = (tmp[1] + tmp[3]) % MODULO;
            keys[9] = (tmp[2] + tmp[4]) % MODULO;
        }
        int count = 0;
        for (int n : keys) {
            count += n;
            count %= MODULO;
        }
        return count;
    }
}