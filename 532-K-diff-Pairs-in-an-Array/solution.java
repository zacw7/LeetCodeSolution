class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> numSet = new HashSet();
        Set<Integer> resSet = new HashSet();
        for (int n : nums) {
            if (numSet.contains(n - k) && !resSet.contains(n)) {
                resSet.add(n);;
            }
            numSet.add(n);
        }
        return resSet.size();
    }
}