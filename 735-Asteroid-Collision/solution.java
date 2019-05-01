class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();

        for (int cur : asteroids) {
            if (!stack.isEmpty() && stack.peek() > 0 && cur < 0) {
                int prev = stack.pop();
                if (prev == -cur) {
                    continue;
                } else if (prev > -cur){
                    stack.push(prev);
                } else {
                    while (!stack.isEmpty() && stack.peek() > 0 && -cur > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(cur);
                    } else if (stack.peek() == -cur) {
                        stack.pop();
                    }
                }
            } else {
                stack.push(cur);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}