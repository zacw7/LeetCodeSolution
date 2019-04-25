class Solution {
    // two pointers
    // T: O(n^2)
    // S: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int cur = nums[left] + nums[right];
                if (cur == target) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                } else if (cur < target) {
                    left++;
                } else if (cur > target) {
                    right--;
                }
                while (left - 1 > i && left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right + 1 < nums.length && left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return ans;
    }
}