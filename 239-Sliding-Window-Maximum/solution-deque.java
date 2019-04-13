class Solution {
    // T: O(n)
    // S: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> queue = new LinkedList();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) add(queue, nums, i, k);
        for (int i = 0; i + k - 1 < nums.length; i++) {
            add(queue, nums, i + k - 1, k);
            ans[i] = nums[queue.peekFirst()];
        }
        return ans;
    }

    // monotonic queue
    private void add(Deque<Integer> queue, int[] nums, int index, int k) {
        if (!queue.isEmpty() && index - queue.peekFirst() == k) queue.pollFirst();
        while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[index]) queue.pollLast();
        queue.offerLast(index);
    }
}