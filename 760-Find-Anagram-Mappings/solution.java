class Solution {
    // T: O(MN)
    // S: O(1)
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}