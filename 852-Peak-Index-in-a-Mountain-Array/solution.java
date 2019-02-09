class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (i + 1 < A.length && A[i] < A[i + 1]) i++;
        return i;
    }
}