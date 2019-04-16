class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int n = 0;
        for (int d : data) {
            int mask = 1 << 7;
            int cur = 0;
            while ((d & mask) > 0) {
                cur++;
                mask >>>= 1;
            }
            if (n == 0) {
                if (cur == 1) {
                    return false;
                } else if (cur > 1) {
                    n = cur - 1;
                    if (n >= 4) return false;
                }
            } else {
                if (cur == 1) {
                    n--;
                } else {
                    return false;
                }
            }
        }
        return n == 0;
    }
}