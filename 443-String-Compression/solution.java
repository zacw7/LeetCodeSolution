class Solution {
    public int compress(char[] chars) {
        if (chars.length == 0) return 0;
        int curIndex = 0, count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[curIndex]) {
                count++;
            } else {
                if (count > 1) {
                    Stack<Integer> nums = new Stack();
                    do {
                        nums.push(count % 10);
                        count /= 10;
                    } while (count > 0);
                    while (!nums.isEmpty()) chars[++curIndex] = (char) ('0' + nums.pop());
                }
                curIndex++;
                count = 1;
                chars[curIndex] = chars[i];
            }
        }
        if (count > 1) {
            Stack<Integer> nums = new Stack();
            do {
                nums.push(count % 10);
                count /= 10;
            } while (count > 0);
            while (!nums.isEmpty()) chars[++curIndex] = (char) ('0' + nums.pop());
        }
        return curIndex + 1;
    }
}