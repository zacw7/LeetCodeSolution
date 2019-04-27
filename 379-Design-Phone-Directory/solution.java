class PhoneDirectory {

    private boolean[] available;
    private Queue<Integer> numQueue;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.available = new boolean[maxNumbers];
        this.numQueue = new LinkedList();
        Arrays.fill(available, true);
        for (int i = 0; i < maxNumbers; i++) {
            numQueue.offer(i);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (numQueue.isEmpty()) {
            return -1;
        } else {
            int n = numQueue.poll();
            available[n] = false;
            return n;
        }
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= available.length) {
            return false;
        }
        return available[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= 0 && number < available.length && !available[number]) {
            available[number] = true;
            numQueue.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */