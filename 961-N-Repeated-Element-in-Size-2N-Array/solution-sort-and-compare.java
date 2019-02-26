class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i <= A.length; i++) {
            if (A[i] == A[i - 1]) return A[i];
        }
        return 0;
    }
}