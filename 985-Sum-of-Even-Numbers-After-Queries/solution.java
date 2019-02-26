class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        for (int a : A) {
            if (a % 2 == 0) evenSum += a;
        }
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], index = queries[i][1];
            int before = A[index];
            A[index] += val;
            if (A[index] % 2 == 0) {
                if (before % 2 == 0) {
                    evenSum += val;
                } else {
                    evenSum += A[index];
                }
            } else if (before % 2 == 0) {
                evenSum -= before;
            }
            ans[i] = evenSum;
        }
        return ans;
    }
}