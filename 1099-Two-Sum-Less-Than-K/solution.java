class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int sum = -1;
        while (l < r) {
            if (A[l] + A[r] < K) {
                sum = Math.max(sum, A[l] + A[r]);
                l++;
            } else {
                r--;
            }
        }
        return sum;
    }
}