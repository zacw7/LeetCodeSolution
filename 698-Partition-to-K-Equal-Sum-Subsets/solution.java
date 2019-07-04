class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k > 0) {
            return false;
        }
        return canPartitionKSubsets(nums, new int[nums.length], 0, sum / k, k);
    }

    private Set<String> cache = new HashSet();
    private boolean canPartitionKSubsets(int[] nums, int[] used, int cur, int sum, int k) {
        if (k == 0) {
            return true;
        }
        String key = Arrays.toString(used);
        if (cache.contains(key)) {
            return false;
        }
        if (cur > sum) {
            return false;
        } else if (cur == sum) {
            return canPartitionKSubsets(nums, used, 0, sum, k - 1);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] == 0) {
                    used[i] = 1;
                    if (canPartitionKSubsets(nums, used, cur + nums[i], sum, k)) {
                        return true;
                    }
                    used[i] = 0;
                }
            }
            cache.add(key);
            return false;
        }
    }
}