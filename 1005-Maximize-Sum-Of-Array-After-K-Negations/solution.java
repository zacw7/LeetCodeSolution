class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0, min = Integer.MAX_VALUE;
        for (int a : A) {
            sum += a;
            if (Math.abs(a) < min) min = Math.abs(a);
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] < 0 && K > 0; i++) {
            A[i] = -A[i];
            sum += 2 * A[i];
            K--;
        }
        if (K % 2 == 0) return sum;
        else return sum -= 2 * min;
    }
}