class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int R = matrix.length, C = matrix[0].length;
        for (int r = 0; r < R; r++) {
            if (matrix[r][0] > target || matrix[r][C - 1] < target) continue;
            int lo = 0, hi = C - 1, mid = hi - (hi - lo) / 2;
            if (matrix[r][lo] == target || matrix[r][hi] == target) return true;
            while (lo < hi - 1) {
                if (matrix[r][mid] < target) lo = mid;
                else if(matrix[r][mid] > target) hi = mid;
                else return true;
                mid = hi - (hi - lo) / 2;
            }
        }
        return false;
    }
}