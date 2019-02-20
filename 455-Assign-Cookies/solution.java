class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0, count = 0;
        while(child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                count++;
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }
        return count;
    }
}