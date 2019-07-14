class Solution {
    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int modeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j + 1 < nums.length && nums[i] == nums[j + 1]) {
                j++;
            }
            if (j - i + 1 > modeCount) {
                modeCount = j - i + 1;
            }
            i = j;
        }
        return modeCount * K <= nums.length;
    }
}