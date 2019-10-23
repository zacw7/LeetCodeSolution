class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int N = nums.length;
        double[] ans = new double[N - k + 1];
        for (int i = 0; i < N; i++) {
            int j = i - k + 1;
            addNum(nums[i], minHeap, maxHeap);
            if (j >= 0) {
                ans[j] = getMedian(minHeap, maxHeap);
                removeNum(nums[j], minHeap, maxHeap);
            }
        }
        return ans;
    }

    private void addNum(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (!maxHeap.isEmpty() && n <= maxHeap.peek()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
    }

    private void removeNum(int n, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (!minHeap.isEmpty() && n >= minHeap.peek()) {
            minHeap.remove(n);
        } else {
            maxHeap.remove(n);
        }
    }

    private double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        while (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
        while (minHeap.size() < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size()) {
            return minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
        } else {
            return minHeap.peek() * 1.0;
        }
    }
}