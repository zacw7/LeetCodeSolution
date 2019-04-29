class FreqStack {

    private Map<Integer, Integer> countMap;
    private Map<Integer, Stack<Integer>> group;
    private int maxFreq;

    public FreqStack() {
        this.countMap = new HashMap();
        this.group = new HashMap();
        this.maxFreq = 0;
    }

    public void push(int x) {
        int count = countMap.getOrDefault(x, 0) + 1;
        countMap.put(x, count);
        Stack<Integer> stack = group.getOrDefault(count, new Stack());
        stack.push(x);
        group.put(count, stack);
        maxFreq = Math.max(maxFreq, count);
    }

    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int x = stack.pop();
        countMap.put(x, countMap.get(x) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */