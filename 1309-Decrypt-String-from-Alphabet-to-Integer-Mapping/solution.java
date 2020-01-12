class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i + 2 < chs.length && chs[i + 2] == '#') {
                int d = (chs[i] - '0') * 10 + chs[i + 1] - '0';
                sb.append((char)('a' + d - 1));
                i += 2;
            } else {
                sb.append((char)('a' + chs[i] - '0' - 1));
            }
        }
        return sb.toString();
    }
}