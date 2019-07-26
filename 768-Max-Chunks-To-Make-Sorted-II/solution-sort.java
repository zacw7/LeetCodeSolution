class Solution {
    // TC: O(nlogn)
    // SC: O(n)
    public int maxChunksToSorted(int[] arr) {
        int[] expect = arr.clone();
        Arrays.sort(expect);
        int count = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += expect[i];
            if (sum1 == sum2) {
                count++;
            }
        }
        return count;
    }
}