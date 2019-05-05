class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] A = new int[length];
        for (int[] op : updates){
            A[op[0]] += op[2];
            if (op[1] + 1 < A.length) {
                A[op[1] + 1] -= op[2];
            }
        }
        int left = 0, right = length - 1;
        int cur = 0;
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
        return A;
    }
}