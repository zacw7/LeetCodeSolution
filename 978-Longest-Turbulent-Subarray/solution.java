class Solution {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1) return 1;
        int[] delta = new int[A.length - 1];
        for (int i = 0; i < A.length -1; i++) {
            if (A[i + 1] > A[i]) delta[i] = 1;
            else if (A[i + 1] < A[i]) delta[i] = -1;
            else delta[i] = 0;
        }
        int max = 0;
        for (int i = 0, prev = 0, len = 1; i < delta.length; i++) {
            int cur = delta[i];
            if (cur == 0) len = 1;
            else if (prev * cur >= 0) len = 2;
            else len++;
            prev = cur;
            max = Math.max(max, len);
        }
        return max;
    }
}