class Solution {
    public int kthGrammar(int N, int K) {
        Stack<Integer> stack = new Stack();
        for (int k = K, i = 0; i < N; i++) {
            stack.push(k);
            k = (k + 1) / 2;
        }
        int n = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() % 2 == 0) {
                n = 1 - n;
            }
        }
        return n;
    }
}