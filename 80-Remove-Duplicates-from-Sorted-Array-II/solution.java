class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int slow = 1, fast = 1;
        boolean duplicated = false;
        while (fast < nums.length) {
            nums[slow] = nums[fast];
            if (nums[slow] == nums[slow - 1]) {
                if (duplicated) {
                    while(fast < nums.length && nums[slow] == nums[fast]) fast++;
                    continue;
                }
                duplicated = true;
            } else {
                duplicated = false;
            }
            slow++;
            fast++;
        }
        return slow;
    }
}