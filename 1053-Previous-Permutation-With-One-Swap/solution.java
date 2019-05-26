class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                int j = i + 1;
                while (j < A.length - 1 && A[j + 1] < A[i]) {
                    j++;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                break;
            }
        }
        return A;
    }
}