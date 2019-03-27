class Solution {
    public int missingNumber(int[] nums) {
        boolean[] seen = new boolean[nums.length + 1];
        for (int n : nums) seen[n] = true;
        for (int i = 0; i < seen.length; i++) {
            if (seen[i] == false) return i;
        }
        return 0;
    }
}