class Solution {
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        for (int row = 0; row < R; row++) {
            if (A[row][0] == 0) {
                for (int col = 0; col < C; col++) {
                    A[row][col] = 1 - A[row][col];
                }
            }
        }
        int ans = 0;
        for (int col = 0; col < C; col++) {
            int ones = 0;
            for (int row = 0; row < R; row++) {
                if(A[row][col] == 1) ones++;
            }
            int digit = Math.max(ones, R - ones);
            ans <<= 1;
            ans += digit;
        }
        return ans;
    }
}