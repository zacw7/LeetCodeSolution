class MyQueue {

    private Stack<Integer> stackI;
    private Stack<Integer> stackO;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackI = new Stack();
        stackO = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackI.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stackO.isEmpty()) {
            dataMigrate();
        }
        return stackO.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stackO.isEmpty()) {
            dataMigrate();
        }
        return stackO.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackO.isEmpty() && stackI.isEmpty();
    }

    private void dataMigrate() {
        while (!stackI.isEmpty()) {
            stackO.push(stackI.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */