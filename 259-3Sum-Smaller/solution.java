class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < t) {
                    count += right - left;
                    left++;
                } else if (nums[left] + nums[right] >= t) {
                    right--;
                }
            }
        }
        return count;
    }
}