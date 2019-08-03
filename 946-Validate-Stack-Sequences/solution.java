class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int i = 0, j = 0;
        while (j < popped.length) {
            while (i < pushed.length && (stack.isEmpty() || stack.peek() != popped[j])) {
                stack.push(pushed[i++]);
            }
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}