class Solution {
    // T: O(n^2)
    // S: O(max(dist))
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] count = new int[nums[nums.length - 1] - nums[0] + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[nums[j] - nums[i]]++;
            }
        }
        System.out.println(Arrays.toString(count));
        for (int dist = 0; dist <= count.length; dist++) {
            if (k <= count[dist]) return dist;
            else k -= count[dist];
        }
        return -1;
    }
}