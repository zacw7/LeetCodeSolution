class Solution {
    public int sumOfDigits(int[] A) {
        int num = A[0];
        for (int a : A) {
            num = Math.min(num, a);
        }
        int s = 0;
        while (num > 0) {
            s += num % 10;
            num /= 10;
        }
        return (s % 2 == 1) ? 0 : 1;
    }
}