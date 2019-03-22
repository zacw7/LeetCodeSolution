class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int shift = 0;
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        if (nums[low] > nums[high]) {
            // find how many numbers rotated
            while (mid != low && mid != high && mid > 0 && nums[mid] > nums[mid - 1]) {
                if (nums[mid] > nums[0]) low = mid;
                if (nums[mid] < nums[0]) high = mid;
                mid = (low + high) / 2;
            }
            shift = mid;
        }
        // check nums[high], nums[low]
        low = shift;
        high = shift + nums.length - 1;
        if (target == nums[low % nums.length]) return low % nums.length;
        if (target == nums[high % nums.length]) return high % nums.length;
        mid = (low + high) / 2;
        while (mid != low && mid != high) {
            int cur = mid % nums.length;
            if (nums[cur] == target) break;
            if (nums[cur] < target) low = mid;
            if (nums[cur] > target) high = mid;
            mid = (low + high) / 2;
        }
        return (mid == low || mid == high) ? -1 : mid % nums.length;
    }
}