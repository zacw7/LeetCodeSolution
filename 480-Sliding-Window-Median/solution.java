class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new double[0];
        }
        int N = nums.length;
        double[] ans = new double[N - k + 1];
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            addNum(minHeap, maxHeap, nums[i]);
        }
        for (int i = k - 1; i < N; i++) {
            addNum(minHeap, maxHeap, nums[i]);
            int j = i - k + 1;
            if (minHeap.size() == maxHeap.size()) {
                ans[j] = (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                ans[j] = 1.0 * minHeap.peek();
            }
            removeNum(minHeap, maxHeap, nums[j]);
        }
        return ans;
    }

    private void addNum(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, long num) {
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        while (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        while (maxHeap.size() < minHeap.size() - 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private void removeNum(PriorityQueue<Long> minHeap, PriorityQueue<Long> maxHeap, long num) {
        if (!maxHeap.isEmpty() && num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }
}