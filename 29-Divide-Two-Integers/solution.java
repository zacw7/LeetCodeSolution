class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        boolean positive = (dividend > 0) == (divisor > 0);
        dividend = (dividend < 0) ? dividend : -dividend;
        divisor = (divisor < 0) ? divisor : -divisor;
        int res = divideHelper(dividend, divisor);
        return (positive) ? res : -res;
    }

    private int divideHelper(int dividend, int divisor) {
        if (divisor < dividend) {
            return 0;
        }
        int sum = divisor, count = 1;
        while (sum > dividend && (sum + sum < 0 && sum + sum >= dividend)) {
            sum += sum;
            count += count;
        }
        return count + divideHelper(dividend - sum, divisor);
    }
}