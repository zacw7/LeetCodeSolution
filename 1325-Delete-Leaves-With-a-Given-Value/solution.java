class Solution {
    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        List<String> res = new ArrayList();
        boolean flag = true;
        int idx = 0;
        while (flag) {
            flag = false;
            StringBuilder sb = new StringBuilder();
            for (String w : strs) {
                if (idx < w.length()) {
                    flag = true;
                    sb.append(w.charAt(idx));
                } else {
                    sb.append(' ');
                }
            }
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == ' ') {
                    sb.setLength(i);
                } else {
                    break;
                }
            }
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
            idx++;
        }
        return res;
    }
}