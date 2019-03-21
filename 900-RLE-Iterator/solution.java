class RLEIterator {

    private Queue<Integer> sequence = new LinkedList();
    private int curNum = 0, curDigit = 0;

    public RLEIterator(int[] A) {
        for (int i = 0, groups = A.length / 2; i < groups; i++) {
            int num = A[i * 2], code = A[i * 2 + 1];
            if (num > 0) {
                sequence.add(num);
                sequence.add(code);
            }
        }
    }

    public int next(int n) {
        while (n > curNum) {
            if (sequence.isEmpty()) {
                curNum = 0;
                return -1;
            }
            n -= curNum;
            curNum = sequence.poll();
            curDigit = sequence.poll();
        }
        curNum -= n;
        return curDigit;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */