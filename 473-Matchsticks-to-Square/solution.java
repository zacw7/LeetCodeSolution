class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum == 0 || sum % 4 > 0) {
            return false;
        }
        int edge = sum / 4;
        return canMake(nums, new int[nums.length], 0, edge, 0, new HashSet());
    }

    private boolean canMake(int[] nums, int[] used, int len, int edge, int formed, Set<String> seen) {
        if (seen.contains(Arrays.toString(used))) {
            return false;
        }
        if (len == edge) {
            return canMake(nums, used, 0, edge, formed + 1, seen);
        }
        if (formed == 3) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0 && len + nums[i] <= edge) {
                used[i] = 1;
                if (canMake(nums, used, len + nums[i], edge, formed, seen)) {
                    return true;
                }
                used[i] = 0;
            }
        }
        seen.add(Arrays.toString(used));
        return false;
    }
}