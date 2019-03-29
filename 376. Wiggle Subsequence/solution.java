class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 1, prev = 0;
        while (prev == 0 && i < nums.length) {
            prev = nums[i] - nums[i - 1];
            i++;
        }
        if (prev == 0) return 1;
        int len = 2;
        while (i < nums.length) {
            int cur = nums[i] - nums[i - 1];
            if (prev * cur < 0) {
                prev = cur;
                len++;
            }
            i++;
        }
        return len;
    }
}