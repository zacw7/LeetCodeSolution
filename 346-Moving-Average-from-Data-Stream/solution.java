class MovingAverage {

    private Queue<Integer> queue;
    private int sum, size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList();
    }

    public double next(int val) {
        if (queue.size() == size) sum -= queue.poll();
        queue.add(val);
        sum += val;
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */