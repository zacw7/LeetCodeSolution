class Solution {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack();
        stack.push(N);
        for (int i = 1; i < N; i++) {
            int n = N - i;
            int oper = i % 4;
            if (i % 4 == 1) { // *
                stack.push(stack.pop() * n);
            } else if (i % 4 == 2) { // /
                stack.push(stack.pop() / n);
            } else if (i % 4 == 3) { // +
                stack.push(stack.pop() + n);
            } else if (i % 4 == 0) { // -
                stack.push(-n);
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}