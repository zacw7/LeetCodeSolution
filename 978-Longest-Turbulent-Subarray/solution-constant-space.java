class Solution {
    public int maxTurbulenceSize(int[] A) {
        int max = 1;
        for (int i = 1, prev = 0, len = 1; i < A.length; i++) {
            int cur = (A[i] == A[i - 1]) ? 0
                    : ((A[i] > A [i - 1]) ? 1 : -1);
            if (cur == 0) len = 1;
            else if (prev * cur >= 0) len = 2;
            else len++;
            prev = cur;
            max = Math.max(max, len);
        }
        return max;
    }
}