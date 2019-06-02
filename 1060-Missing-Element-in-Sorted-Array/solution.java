class Solution {
    // one pass
    // TC: O(N)
    // SC: 1
    public int missingElement(int[] nums, int k) {
        int n = nums[0];
        int i = 0;
        while (k > 0) {
            if (i < nums.length) {
                if (n == nums[i]) {
                    n++;
                    i++;
                } else {
                    n++;
                    k--;
                }
            } else {
                break;
            }
        }
        return n + k - 1;
    }
}