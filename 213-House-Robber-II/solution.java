class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length <= 3) {
            int max = Integer.MIN_VALUE;
            for (int n : nums) max = Math.max(max, n);
            return max;
        }
        int[] head = nums.clone(), tail = nums.clone();
        nums[0] = head[1] = tail[0] = 0;
        for (int i = 3; i < head.length - 1; i++) {
            head[i] = Math.max(head[i - 1], head[i - 2] + head[i]);
        }
        for (int i = 2; i < tail.length - 2; i++) {
            tail[i] = Math.max(tail[i - 1], tail[i - 2] + tail[i]);
        }
        for (int i = 2; i < nums.length - 1; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return Math.max(nums[nums.length - 2],
                Math.max(head[head.length - 2] + head[0], tail[tail.length - 3] + tail[tail.length - 1]));
    }
}