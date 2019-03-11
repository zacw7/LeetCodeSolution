class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) return -1;
        int sum = 0;
        for (int n : nums) sum += n;

        int left = 0, right = sum;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) return i;
            left += nums[i];
        }
        return -1;
    }
}