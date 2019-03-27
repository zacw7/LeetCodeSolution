class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        while (last >= 0 && nums[last] == val) last--;
        for (int i = 0; i < last; i++) {
            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
            }
            while (last >= 0 && nums[last] == val) last--;
        }
        return last + 1;
    }
}