class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> res = new TreeSet();
        List<StringBuilder> cur = new ArrayList();
        cur.add(new StringBuilder());
        int unmatch = 0, left = -1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '{') {
                if (unmatch == 0) {
                    left = i;
                }
                unmatch++;
            } else if (c == '}') {
                unmatch--;
                if (unmatch == 0) {
                    List<String> list = braceExpansionII(expression.substring(left + 1, i));
                    List<StringBuilder> tmp = new ArrayList();
                    for (String s : list) {
                        for (StringBuilder sb : cur) {
                            StringBuilder newSb = new StringBuilder(sb);
                            newSb.append(s);
                            tmp.add(newSb);
                        }
                    }
                    cur = tmp;
                }
            } else if (unmatch == 0) {
                if (c == ',') {
                    for (StringBuilder sb : cur) {
                        res.add(sb.toString());
                    }
                    cur.clear();
                    cur.add(new StringBuilder());
                } else {
                    for (StringBuilder sb : cur) {
                        sb.append(c);
                    }
                }
            }
        }
        for (StringBuilder sb : cur) {
            res.add(sb.toString());
        }
        return new ArrayList(res);
    }
}