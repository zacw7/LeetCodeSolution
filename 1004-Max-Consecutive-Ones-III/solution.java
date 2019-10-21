class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0, r = 0;
        int maxLen = 0;
        int count = 0;
        while (r < A.length) {
            count += A[r];
            r++;
            while (r - l - count > K) {
                count -= A[l];
                l++;
            }
            maxLen = Math.max(r - l, maxLen);
        }
        return maxLen;
    }
}