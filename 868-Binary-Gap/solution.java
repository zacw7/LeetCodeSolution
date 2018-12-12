class Solution {
    public int binaryGap(int N) {
        int dist = 0, last = -1;
        for (int i = 0; i < Integer.SIZE; i++, N = N >> 1) {
            if ((N & 1) > 0) {
                if (last >= 0 && i - last > dist) dist = i - last;
                last = i;
            }
        }
        return dist;
    }
}