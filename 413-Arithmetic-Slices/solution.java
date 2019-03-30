class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int cur = 2, diff = A[1] - A[0], count = 0;
        for (int i = 2; i < A.length; i++) {
            if (diff == A[i] - A[i - 1]) {
                cur++;
            } else {
                if (cur >= 3) count += cur * (cur - 3) / 2 + 1;
                cur = 2;
                diff = A[i] - A[i - 1];
            }
        }
        if (cur >= 3) count += cur * (cur - 3) / 2 + 1;
        return count;
    }
}