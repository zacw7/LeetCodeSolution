class MedianFinder {

    private Queue<Integer> minHeap, maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue();
        this.maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (minHeap.size() < maxHeap.size()) minHeap.add(num);
        else maxHeap.add(num);
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            while (maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if ((maxHeap.size() + minHeap.size()) % 2 == 1) return maxHeap.peek();
        else return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */