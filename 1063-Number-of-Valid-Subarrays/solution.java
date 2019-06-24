class Solution {
    // find the next greater element -> monotone stack
    public int validSubarrays(int[] nums) {
        int count = 0;
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                count += nums.length - i;
            } else {
                count += stack.peek() - i;
            }
            stack.push(i);
        }
        return count;
    }
}