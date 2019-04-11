class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        Set<Integer> set = new HashSet();
        for (int t = 0; t < nums.length; t++) {
            if (t > 0 && nums[t] == nums[t - 1]) continue;
            if (t == nums.length) break;
            int target = -nums[t];
            set.clear();
            for (int i = t + 1; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[t]);
                    list.add(nums[i]);
                    list.add(target - nums[i]);
                    ans.add(list);
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
                } else set.add(target - nums[i]);
            }
        }
        return ans;
    }
}