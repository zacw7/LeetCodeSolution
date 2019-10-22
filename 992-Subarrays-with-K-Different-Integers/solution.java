class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithinKDistinct(A, K) - subarraysWithinKDistinct(A, K - 1);
    }

    private int subarraysWithinKDistinct(int[] A, int K) {
        if (A == null || A.length == 0 || K <= 0) {
            return 0;
        }
        int[] count = new int[A.length + 1];
        int cur = 0;
        int res = 0;
        int l = 0, r = 0;
        while (r < A.length) {
            if (count[A[r]] == 0) {
                cur++;
            }
            count[A[r]]++;
            r++;
            while (cur > K) {
                count[A[l]]--;
                if (count[A[l]] == 0) {
                    cur--;
                }
                l++;
            }
            res += r - l;
        }
        return res;
    }
}