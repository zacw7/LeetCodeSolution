class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int LEN = s.length();
        int[] diff = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int cur = 0;
        int l = 0, r = 0;
        int max = 0;
        while (r < LEN) {
            cur += diff[r];
            r++;
            while (cur > maxCost) {
                cur -= diff[l];
                l++;
            }
            max = Math.max(max, r - l);
        }
        return max;
    }
}