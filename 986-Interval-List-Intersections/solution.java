class Solution {
    // TC: O(N)
    // SC: O(N)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> intervals = new ArrayList();
        int i = 0, j  = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] <= B[j][1]) {
                if (A[i][1] >= B[j][0]) {
                    intervals.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                }
                i++;
            } else {
                if (B[j][1] >= A[i][0]) {
                    intervals.add(new int[]{Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
                }
                j++;
            }
        }
        return intervals.toArray(new int[intervals.size()][]);
    }
}