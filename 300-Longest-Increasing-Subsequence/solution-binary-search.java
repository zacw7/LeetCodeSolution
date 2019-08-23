class Solution {
    // binary search
    // TC: O(nlogn)
    // SC: O(n)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] dp = new int[nums.length];
        for (int n : nums) {
            int i = insertIndex(dp, len, n);
            dp[i] = n;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    // find the index of first greater or equal number
    private int insertIndex(int[] dp, int i, int n) {
        if (i == 0) {
            return 0;
        }
        if (n > dp[i - 1]) {
            return i;
        }
        int lo = 0, hi = i - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}