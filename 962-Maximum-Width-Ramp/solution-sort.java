class Solution {
    // T: O(NlogN)
    // S: O(N)
    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = i;
        }
        Arrays.sort(B, (o1, o2) -> A[o1] - A[o2]);
        int minIndex = A.length;
        int maxWidth = 0;
        for (int index : B) {
            maxWidth = Math.max(maxWidth, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }
        return maxWidth;
    }
}