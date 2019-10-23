class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        char ch = chars[0];
        int count = 1;
        int idx = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        chars[idx++] = c;
                    }
                }
                chars[idx++] = chars[i];
                count = 1;
            }
        }
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[idx++] = c;
            }
        }
        return idx;
    }
}