class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        if (nums[low] == target) return low;
        if (nums[high] == target) return high;
        while (low < high - 1) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) low = mid;
            else high = mid;
        }
        return -1;
    }
}