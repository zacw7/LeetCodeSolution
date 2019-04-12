class Solution {
    // T: O(nlogk)
    // S: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (nums.length <= k) {
            int max = 0;
            for (int n : nums) max = Math.max(max, n);
            return new int[]{max};
        }
        TreeMap<Integer, Integer> maxHeap = new TreeMap();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) maxHeap.put(nums[i], maxHeap.getOrDefault(nums[i], 0) + 1);
        ans[0] = maxHeap.lastKey();
        if (k > 0) {
            for (int i = 1; i < ans.length; i++) {
                int cur = nums[i + k - 1];
                maxHeap.put(cur, maxHeap.getOrDefault(cur, 0) + 1);
                int prevCount = maxHeap.get(nums[i - 1]) - 1;
                if (prevCount > 0) maxHeap.put(nums[i - 1], prevCount);
                else maxHeap.remove(nums[i - 1]);
                ans[i] = maxHeap.lastKey();
            }
        }
        return ans;
    }
}