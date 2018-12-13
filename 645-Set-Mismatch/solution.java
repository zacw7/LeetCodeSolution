class Solution {
    public int[] findErrorNums(int[] nums) {
        int N = nums.length, sum = 0;
        int duplicatedNum = 0;
        for (int i = 0; i < N; i++) {
            int index = Math.abs(nums[i]);
            sum += index;
            index -= 1;
            if (nums[index] < 0) duplicatedNum = index + 1;
            else nums[index] = 0 - nums[index];
        }

        int offset = (1 + N) * N / 2 - sum;
        int[] ans = new int[]{duplicatedNum, duplicatedNum + offset};
        return ans;
    }
}