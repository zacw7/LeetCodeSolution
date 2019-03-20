class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr.length <= 1) return arr.length;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - i;
        }
        int count = 0;
        for (int i = 0, cur = 0; i < arr.length; i++) {
            cur += arr[i];
            if (cur == 0) count++;
        }
        return count;
    }
}