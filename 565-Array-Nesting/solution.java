class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i], count = 0;
            while (!seen.contains(cur)) {
                seen.add(cur);
                cur = nums[cur];
                count++;
            }
            if (count > max) max = count;
        }
        return max;
    }
}