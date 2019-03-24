class Solution {
    private List<String> ans = new ArrayList();

    public List<String> restoreIpAddresses(String s) {
        if (s != null && s.length() >= 4)
            helper(s, new StringBuilder(), 0, 1, s.length());
        return ans;
    }

    private void helper(String s, StringBuilder sb, int start, int index, int len) {
        if (index > 4 && start == len) {
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
        } else if (start < len && index <= 4){
            for (int i = 1; i <= 3 && start + i <= len; i++) {
                int seg = Integer.valueOf(s.substring(start, start + i));
                if (seg < 10 && i > 1) return;
                if (seg >= 0 && seg <= 255) {
                    StringBuilder cur = new StringBuilder(sb);
                    cur.append(seg);
                    cur.append('.');
                    helper(s, cur, start + i, index + 1, len);
                }
            }
        }
    }
}