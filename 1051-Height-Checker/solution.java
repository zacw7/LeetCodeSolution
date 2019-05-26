class Solution {
    // sort and compare
    // TC: O(NlogN)
    // SC: O(N)
    public int heightChecker(int[] heights) {
        if (heights == null || heights.length <= 1) {
            return 0;
        }
        int[] sortedH = heights.clone();
        Arrays.sort(sortedH);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedH[i]) {
                res++;
            }
        }
        return res;
    }
}