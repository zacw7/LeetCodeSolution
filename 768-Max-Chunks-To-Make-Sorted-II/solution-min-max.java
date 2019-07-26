class Solution {
    // TC: O(n)
    // SC: O(n)
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] forward = new int[arr.length];
        forward[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            forward[i] = Math.max(forward[i - 1], arr[i - 1]);
        }
        int[] backward = new int[arr.length];
        backward[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            backward[i] = Math.min(backward[i + 1], arr[i + 1]);
        }
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (forward[i] <= backward[i - 1]) {
                count++;
            }
        }
        return count;
    }
}