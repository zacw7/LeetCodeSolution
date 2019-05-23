class Solution {
    // Stack
    // TC: O(N)
    // SC: O(N)
    public boolean isValid(String S) {
        if (S.length() % 3 > 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (char c : S.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') return false;
                if (stack.isEmpty() || stack.pop() != 'a') return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}