class Solution {
    int A, B, C;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        A = a;
        B = b;
        C = c;
        if (nums == null || nums.length == 0) {
            return nums;
        }
        if (nums.length == 1) {
            nums[0] = transform(nums[0]);
            return nums;
        }
        int[] ans = new int[nums.length];
        if (a >= 0) {
            int i = nums.length - 1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (transform(nums[left]) > transform(nums[right])) {
                    ans[i--] = transform(nums[left++]);
                } else {
                    ans[i--] = transform(nums[right--]);
                }
            }
        } else if (a < 0) {
            int i = 0;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                if (transform(nums[left]) < transform(nums[right])) {
                    ans[i++] = transform(nums[left++]);
                } else {
                    ans[i++] = transform(nums[right--]);
                }
            }
        }
        return ans;
    }

    private int transform(int n) {
        return A * n * n + B * n + C;
    }
}