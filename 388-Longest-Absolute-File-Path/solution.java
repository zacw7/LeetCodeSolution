class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> lenStack = new Stack();
        int maxLen = 0;
        for (int i = 0; i < input.length(); i++) {
            int layer = 0;
            while (i < input.length() && input.charAt(i) == '\t') {
                layer++;
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int curLen = 0;
            boolean isFile = false;
            while (i < input.length() && input.charAt(i) != '\n') {
                if (input.charAt(i) == '.') {
                    isFile = true;
                }
                curLen++;
                i++;
            }
            while (lenStack.size() > layer) {
                lenStack.pop();
            }
            if (isFile) {
                if (lenStack.isEmpty()) {
                    maxLen = Math.max(maxLen, curLen);
                } else {
                    maxLen = Math.max(maxLen, curLen + lenStack.peek());
                }
            } else {
                if (lenStack.isEmpty()) {
                    lenStack.push(curLen + 1);
                } else {
                    lenStack.push(lenStack.peek() + curLen + 1);
                }
            }
        }
        return maxLen;
    }
}