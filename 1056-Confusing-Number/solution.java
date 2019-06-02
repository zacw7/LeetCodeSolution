class Solution {
    public boolean confusingNumber(int N) {
        int origin = N, rotated = 0;
        while (N > 0) {
            int n = N % 10;
            N /= 10;
            rotated *= 10;
            if (n == 0 || n == 1 || n == 8) {
                rotated += n;
            } else if (n == 6) {
                rotated += 9;
            } else if (n == 9) {
                rotated += 6;
            } else {
                return false;
            }
        }
        return rotated != origin;
    }
}