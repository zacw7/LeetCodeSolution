class Solution {
    // T: O(n^2)
    // S: O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int t = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int cur = nums[left] + nums[right];
                if (Math.abs(t - cur) < min) {
                    min = Math.abs(t - cur);
                    ans = nums[i] + cur;
                }
                if (cur < t) left++;
                else if (cur > t) right--;
                else return target;
            }
        }
        return ans;
    }
}