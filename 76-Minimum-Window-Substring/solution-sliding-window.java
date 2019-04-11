class Solution {
    public String minWindow(String s, String t) {
        int[] target = new int[256];
        int[] source = new int[256];
        for (char c : t.toCharArray()) target[c]++;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (left <= right) {
            if (isValid(source, target)) {
                int len = right - left;
                if (len < min) {
                    min = len;
                    res = s.substring(left, right);
                }
                source[s.charAt(left++)]--;
            } else {
                if (right >= s.length()) break;
                source[s.charAt(right++)]++;
            }
        }
        return res;
    }

    private boolean isValid(int[] source, int[] target) {
        for (int i = 0; i < 256; i++) {
            if (source[i] < target[i]) return false;
        }
        return true;
    }
}