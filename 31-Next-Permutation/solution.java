class Solution {
    public void nextPermutation(int[] nums) {
        int ptr = nums.length - 2;
        while (ptr >= 0 && nums[ptr + 1] <= nums[ptr]) ptr--;
        if (ptr < 0) {
            Arrays.sort(nums);
        } else {
            // find the min number while larger than nums[ptr]
            int min = Integer.MAX_VALUE, idx = -1;
            for (int i = ptr + 1; i < nums.length; i++) {
                if (nums[i] > nums[ptr] && nums[i] < min) {
                    idx = i;
                    min = nums[i];
                }
            }
            int tmp = nums[ptr];
            nums[ptr] = nums[idx];
            nums[idx] = tmp;
            Arrays.sort(nums, ptr + 1, nums.length);
        }
    }
}