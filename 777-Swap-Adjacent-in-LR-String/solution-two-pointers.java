class Solution {
    // Two Pointers
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        int LEN = start.length();
        int i1 = 0, i2 = 0;
        char[] chs1 = start.toCharArray(), chs2 = end.toCharArray();
        while (i1 < LEN) {
            if (chs1[i1] != chs2[i2] && chs1[i1] == 'X' && chs2[i2] == 'L') {
                int t = i1 + 1;
                while (t < LEN && chs1[t] == 'X') {
                    t++;
                }
                if (t < LEN && chs1[t] == 'L') {
                    swap(chs1, i1, t);
                }
            }
            i1++;
            i2++;
        }
        i1 = i2 = LEN - 1;
        while (i1 >= 0) {
            if (chs1[i1] != chs2[i2] && chs1[i1] == 'X' && chs2[i2] == 'R') {
                int t = i1 - 1;
                while (t >= 0 && chs1[t] == 'X') {
                    t--;
                }
                if (t >= 0 && chs1[t] == 'R') {
                    swap(chs1, i1, t);
                }
            }
            i1--;
            i2--;
        }
        return new String(chs1).equals(new String(chs2));
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}