class CombinationIterator {

    private char[] chs;
    private int len;
    private int[] comb;
    private Stack<Integer> stack;

    public CombinationIterator(String characters, int combinationLength) {
        this.chs = characters.toCharArray();
        this.len = combinationLength;
        this.comb = new int[len];
        this.stack = new Stack();

        Arrays.sort(chs);
        for (int i = 0; i < len; i++) {
            stack.push(i);
            comb[i] = i;
        }
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(chs[comb[i]]);
        }
        int idx = stack.pop();
        if (comb[idx] + 1 < chs.length) {
            comb[idx]++;
            stack.push(idx);
        } else {
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                if (comb[cur] + len - stack.size() < chs.length) {
                    comb[cur]++;
                    stack.push(cur);
                    break;
                }
            }
            while (!stack.isEmpty() && stack.size() < len) {
                comb[stack.peek() + 1] = comb[stack.peek()] + 1;
                stack.push(stack.peek() + 1);
            }
        }
        return sb.toString();
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */