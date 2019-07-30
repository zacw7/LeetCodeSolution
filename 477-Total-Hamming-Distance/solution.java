class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 31; i++) {
            int[] count = new int[2];
            for (int n : nums) {
                count[(n >> i) & 1]++;
            }
            total += count[0] * count[1];
        }
        return total;
    }
}