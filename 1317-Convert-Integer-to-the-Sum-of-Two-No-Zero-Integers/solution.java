class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (!containsZero(i) && !containsZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[2];
    }

    private boolean containsZero(int n) {
        if (n == 0) {
            return true;
        }
        while (n > 0) {
            if (n % 10 == 0) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}