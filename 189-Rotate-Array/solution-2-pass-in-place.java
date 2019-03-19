class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        // reverse the array
        for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        // reverse the first k
        for (int left = 0, right = k - 1; left < right; left++, right--) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
        // reverse the last nums.length - k
        for (int left = k, right = nums.length - 1; left < right; left++, right--) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}