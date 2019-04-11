class MaxStack {

    private Stack<Integer> maxStack, stack;

    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack();
        stack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty() || maxStack.peek() <= x) maxStack.push(x);
        else maxStack.push(maxStack.peek());
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> tmp = new Stack();
        while (!stack.isEmpty() && stack.peek() != max) {
            maxStack.pop();
            tmp.push(stack.pop());
        }
        pop();
        while (!tmp.isEmpty()) push(tmp.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */