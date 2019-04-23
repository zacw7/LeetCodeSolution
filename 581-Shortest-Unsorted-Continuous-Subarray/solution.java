class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] <= nums[left + 1]) {
                left++;
            } else if (nums[right] >= nums[right - 1]) {
                right--;
            } else {
                break;
            }
        }

        if (left == right) {
            return 0;
        }
        System.out.println(left);
        System.out.println(right);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        while (right + 1 < nums.length && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}