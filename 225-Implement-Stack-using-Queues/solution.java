class MyStack {

    private Queue<Integer> queue = new LinkedList();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> tmp = new LinkedList();
        while (queue.size() > 1) {
            tmp.add(queue.poll());
        }
        int res = queue.poll();
        queue = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        Queue<Integer> tmp = new LinkedList();
        while (queue.size() > 1) {
            tmp.add(queue.poll());
        }
        int res = queue.poll();
        tmp.add(res);
        queue = tmp;
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */