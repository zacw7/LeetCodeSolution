class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
                count++;
            } else {
                if (n == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return candidate;
    }
}