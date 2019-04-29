class FreqStack {

    private TreeMap<Integer, Set<Integer>> setMap;
    private Map<Integer, Integer> countMap;
    private Stack<Integer> numStack;

    public FreqStack() {
        this.setMap = new TreeMap();
        this.countMap = new HashMap();
        this.numStack = new Stack();
    }

    public void push(int x) {
        numStack.push(x);
        int count = countMap.getOrDefault(x, 0);
        if (count > 0) {
            // process the old treemap
            Set<Integer> set = setMap.get(count);
            set.remove(x);
            if (set.isEmpty()) {
                setMap.remove(count);
            } else {
                setMap.put(count, set);
            }
        }
        count++;
        countMap.put(x, count);
        Set<Integer> set = setMap.getOrDefault(count, new HashSet());
        set.add(x);
        setMap.put(count, set);
    }

    public int pop() {
        int mostFreqCount = setMap.lastKey();
        Set<Integer> numSet = setMap.get(mostFreqCount);
        Stack<Integer> tmp = new Stack();
        while (!numStack.isEmpty() && !numSet.contains(numStack.peek())) {
            tmp.push(numStack.pop());
        }
        int n = numStack.pop();
        while (!tmp.isEmpty()) {
            numStack.push(tmp.pop());
        }

        // process the old treemap
        numSet.remove(n);
        if (numSet.isEmpty()) {
            setMap.remove(mostFreqCount);
        } else {
            setMap.put(mostFreqCount, numSet);
        }
        int count = mostFreqCount - 1;
        if (count > 0) {
            countMap.put(n, count);
            Set<Integer> set = setMap.getOrDefault(count, new HashSet());
            set.add(n);
            setMap.put(count, set);
        } else {
            countMap.remove(n);
        }

        return n;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */