class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int M = matrix.length, N = matrix[0].length;
        if (matrix[0][0] == target || matrix[M - 1][N - 1] == target) return true;
        int low = 0, high = M * N - 1;
        int mid = (low + high) / 2;
        while (mid != low && mid != high) {
            int i = mid / N, j = mid % N;
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) high = mid;
            else low = mid;
            mid = (low + high) / 2;
        }
        return false;
    }
}