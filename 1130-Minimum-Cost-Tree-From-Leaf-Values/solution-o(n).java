class Solution {
    public int mctFromLeafValues(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack();
        stack.push(Integer.MAX_VALUE);
        for (int n : arr) {
            while (stack.peek() <= n) {
                int remove = stack.pop();
                sum += remove * Math.min(stack.peek(), n);
            }
            stack.push(n);
        }
        while (stack.size() > 2) {
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}