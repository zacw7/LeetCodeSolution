class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList();
        if (s == null || s.length() <= 1) {
            return ans;
        }

        char[] c = s.toCharArray();
        for (int i = 1; i < c.length; i++) {
            if (c[i] == c[i - 1] && c[i] == '+') {
                c[i] = c[i - 1] = '-';
                ans.add(new String(c));
                c[i] = c[i - 1] = '+';
            }
        }

        return ans;
    }
}