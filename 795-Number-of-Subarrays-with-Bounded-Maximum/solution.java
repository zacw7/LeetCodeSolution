class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0, left = 0, right = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                left = right = i + 1;
            } else if (A[i] >= L) {
                right = i + 1;
            }
            count += right - left;
        }
        return count;
    }
}