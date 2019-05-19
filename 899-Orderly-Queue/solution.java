class Solution {
    public String orderlyQueue(String S, int K) {
        if (S == null || S.length() <= 1 || K == 0) {
            return S;
        } else if (K == 1) {
            String res = S;
            StringBuilder sb = new StringBuilder(S);
            for (int i = 0; i < S.length(); i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                String cur = sb.toString();
                if (cur.compareTo(res) < 0) {
                    res = cur;
                }
            }
            return res;
        } else {
            char[] chars = S.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}