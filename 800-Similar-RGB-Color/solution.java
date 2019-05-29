class Solution {
    public String similarRGB(String color) {
        if (color == null || color.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 1; i < color.length(); i += 2) {
            int delta = Integer.MAX_VALUE;
            char curChar = ' ';
            for (int d = -1; d <= 1; d++) {
                char c = (char) (color.charAt(i) + d);
                if (c == (char)('9' + 1)) {
                    c = 'a';
                }
                if (c == (char)('a' - 1)) {
                    c = '9';
                }
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
                    int digit1 = Integer.parseInt(new String(new char[]{c, c}), 16);
                    int digit2 = Integer.parseInt(color.substring(i, i + 2), 16);
                    int curDelta = Math.abs(digit1 - digit2);
                    if (curDelta < delta) {
                        curChar = c;
                        delta = curDelta;
                    }
                }
            }
            sb.append(curChar).append(curChar);
        }
        return sb.toString();
    }
}