class Solution {
    public int maximum69Number (int num) {
        char[] chs = String.valueOf(num).toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '6') {
                chs[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(chs));
    }
}