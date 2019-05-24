class Solution {
    public int clumsy(int N) {
        if (N <= 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 2;
        } else if (N == 3) {
            return 6;
        } else if (N == 4) {
            return 7;
        }
        int[] chunks = {0, 1, 1, -2};
        return N * (N - 1) / (N - 2) + chunks[N % 4];
    }
}