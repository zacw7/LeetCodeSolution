class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack();
        int prev = 0;
        for (String log : logs) {
            String[] strs = log.split(":");
            int id = Integer.valueOf(strs[0]), ts = Integer.valueOf(strs[2]);
            ans[id] += 1;
            if (!stack.isEmpty()) {
                ans[stack.peek()] += ts - prev - 1;
            }
            prev = ts;
            if (strs[1].equals("start")) {
                stack.push(id);
            } else {
                stack.pop();
            }
        }
        return ans;
    }
}