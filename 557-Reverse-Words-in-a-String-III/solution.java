class Solution {
    public String reverseWords(String s) {
        Stack<Character> charStack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                while (!charStack.isEmpty()) {
                    sb.append(charStack.pop());
                }
                sb.append(ch);
            } else {
                charStack.push(ch);
            }
        }
        while (!charStack.isEmpty()) {
            sb.append(charStack.pop());
        }
        return sb.toString();
    }
}