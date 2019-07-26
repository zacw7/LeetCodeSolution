class Solution {
    // TC: O(n)
    // SC: O(n)
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        for (int n : arr) {
            if (stack.isEmpty() || n >= stack.peek()) {
                stack.push(n);
            } else {
                int curMax = stack.pop();
                while (!stack.isEmpty() && stack.peek() > n) {
                    stack.pop();
                }
                stack.push(curMax);
            }
        }
        return stack.size();
    }
}