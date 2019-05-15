class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int left = 0, right = 0;
        while (right <= chars.length) {
            if (right == chars.length || chars[left] != chars[right]) {
                chars[i++] = chars[left];
                int count = right - left;
                if (count > 1) {
                    Stack<Integer> stack = new Stack();
                    while (count > 0) {
                        stack.push(count % 10);
                        count /= 10;
                    }
                    while (!stack.isEmpty()) {
                        chars[i++] = (char) (stack.pop() + '0');
                    }
                }
                left = right;
            }
            right++;
        }
        return i;
    }
}