class Solution {
    public int removeElement(int[] nums, int val) {
        int shift = 0;
        int i = 0;
        while (i + shift < nums.length) {
            nums[i] = nums[i + shift];
            if (nums[i] == val) shift++;
            else i++;
        }
        return nums.length - shift;
    }
}