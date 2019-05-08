class Solution {
    public boolean canWin(String s) {
        if (s.indexOf("++") == -1) {
            return false;
        }
        int i = s.indexOf("++", 0);
        while (i != - 1) {
            if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2, s.length()))) {
                return true;
            }
            i = s.indexOf("++", i + 1);
        }
        return false;
    }
}