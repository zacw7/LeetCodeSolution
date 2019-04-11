class KthLargest {

    private Queue<Integer> minHeap;
    private int SIZE;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue();
        this.SIZE = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (minHeap.size() < SIZE) minHeap.add(val);
        else if (val > minHeap.peek()){
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */