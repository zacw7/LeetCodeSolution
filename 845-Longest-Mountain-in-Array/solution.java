class Solution {
    public int longestMountain(int[] A) {
        int cur = 0, max = 0;
        int state = 0;  // 1 - ascending, -1 - descending, 0 - equal
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                // asceding
                if (state == 1) {
                    cur++;
                } else {
                    cur = 2;
                }
                state = 1;
            } else if (A[i] < A[i - 1]) {
                // descending
                if (state != 0) {
                    cur++;
                    state = -1;
                    max = Math.max(cur, max);
                }
            } else {
                state = 0;
                cur = 0;
            }
        }
        return max;
    }
}