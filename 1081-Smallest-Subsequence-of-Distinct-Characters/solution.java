class Solution {
    public String smallestSubsequence(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack();
        for (char c : text.toCharArray()) {
            count[c - 'a']--;
            if (used[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                used[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            used[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}