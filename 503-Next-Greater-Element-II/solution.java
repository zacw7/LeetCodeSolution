class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> monoDescStack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!monoDescStack.isEmpty() && nums[i] >= monoDescStack.peek()) {
                monoDescStack.pop();
            }
            if (monoDescStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = monoDescStack.peek();
            }
            monoDescStack.push(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!monoDescStack.isEmpty() && nums[i] >= monoDescStack.peek()) {
                monoDescStack.pop();
            }
            if (monoDescStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = monoDescStack.peek();
            }
            monoDescStack.push(nums[i]);
        }
        return ans;
    }
}