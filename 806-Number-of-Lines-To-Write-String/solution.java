class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 0, widthLeft = 0;
        for (char ch : S.toCharArray()) {
            int charWidth = widths[ch - 'a'];
            if (widthLeft < charWidth) {
                lines++;
                widthLeft = 100;
            }
            widthLeft -= charWidth;
        }
        return new int[]{lines, 100 - widthLeft};
    }
}