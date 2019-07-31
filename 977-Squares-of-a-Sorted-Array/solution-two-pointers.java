class Solution {
    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int l = 0, r = A.length - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            if (Math.abs(A[l]) > Math.abs(A[r])) {
                ans[i] = A[l] * A[l];
                l++;
            } else {
                ans[i] = A[r] * A[r];
                r--;
            }
        }
        return ans;
    }
}