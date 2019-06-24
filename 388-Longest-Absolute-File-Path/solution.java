class Solution {
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        char[] chs = input.toCharArray();
        Stack<Integer> lenStack = new Stack();
        lenStack.push(0);
        int curLen = 0, curLevel = 1;
        boolean isFile = false;
        int i = 0;
        while(i < chs.length) {
            if (chs[i] == '\n') {
                if (isFile) {
                    maxLen = Math.max(maxLen, curLen + lenStack.peek());
                } else {
                    lenStack.push(lenStack.peek() + curLen + 1);
                }
                isFile = false;
                curLen = 0;
                int level = 1;
                while (i + 1 < chs.length && chs[i + 1] == '\t') {
                    level++;
                    i++;
                }
                while (lenStack.size() > level) {
                    lenStack.pop();
                }
            } else {
                curLen++;
                if (chs[i] == '.') {
                    isFile = true;
                }
            }
            i++;
        }
        if (isFile) {
            maxLen = Math.max(maxLen, curLen + lenStack.peek());
        }
        return maxLen;
    }
}