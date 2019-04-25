class Solution {
    // two-pointers
    // T: O(nlong + n^3)
    // S: O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int t = target - nums[i] - nums[j];
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int cur = nums[left] + nums[right];
                    if (cur == t) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        ans.add(list);
                        left++;
                        right--;
                    } else if (cur < t) {
                        left++;
                    } else if (cur > t) {
                        right--;
                    }
                    while (left - 1 > j && left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right  + 1 < nums.length && left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}