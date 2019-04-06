class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList();
        int len = S.length();
        for (int i = 1; i < len; i++) {
            int n1 = Integer.valueOf(S.substring(0, i));
            for (int j = 1; j < len; j++) {
                if (len - i - j < Math.min(i, j)) break;
                int n2 = Integer.valueOf(S.substring(i, i + j));
                ans.add(n1);
                ans.add(n2);
                if (helper(S, 0, i, j, ans)) return ans;
                else ans.clear();
                if (n2 >= Integer.MAX_VALUE / 10) break;
            }
            if (n1 >= Integer.MAX_VALUE / 10) break;
        }
        return ans;
    }

    private boolean helper(String S, int start, int len1, int len2, List<Integer> list) {
        if (start + len1 + len2 == S.length()) return true;
        String n1Str = S.substring(start, start + len1);
        String n2Str = S.substring(start + len1, start + len1 + len2);
        if (len1 > 1 && n1Str.startsWith("0")) return false;
        if (len2 > 1 && n2Str.startsWith("0")) return false;
        int n1 = Integer.valueOf(n1Str), n2 = Integer.valueOf(n2Str);
        int n3 = n1 + n2;
        list.add(n3);
        String n3Str = String.valueOf(n3);
        int len3 = n3Str.length();
        if (start + len1 + len2 + len3 > S.length()
                || !n3Str.equals(S.substring(start + len1 + len2, start + len1 + len2 + len3))) return false;
        else return helper(S, start + len1, len2, len3, list);
    }
}