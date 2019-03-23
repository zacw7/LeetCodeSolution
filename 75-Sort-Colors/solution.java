class Solution {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int n : nums) colorCount[n]++;
        for (int i = 0, color = 0; color < 3; color++) {
            for (int cnt = colorCount[color]; cnt > 0; cnt--) {
                nums[i++] = color;
            }
        }
    }
}