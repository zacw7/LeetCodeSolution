class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int shift = 0;
        char[] chs = S.toCharArray();
        for (int i = shifts.length - 1; i >= 0; i--) {
            shift += shifts[i];
            shift %= 26;
            chs[i] += shift;
            if (chs[i] > 'z') {
                chs[i] -= 26;
            }
        }
        return new String(chs);
    }
}