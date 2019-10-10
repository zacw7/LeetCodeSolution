class Solution {
    public void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            idx--;
        }
        int min = idx + 1;
        if (idx >= 0) {
            // find the min number which greater than nums[idx]
            for (int i = idx + 2; i < nums.length; i++) {
                if (nums[i] > nums[idx] && nums[i] <= nums[min]) {
                    min = i;
                }
            }
            // swap nums[idx] and nums[min]
            swap(nums, idx, min);
        }
        // reverse nums[idx + 1] ... nums[nums.length - 1]
        int l = idx + 1, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}