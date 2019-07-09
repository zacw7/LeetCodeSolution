class Solution {
    public String[] permute(String S) {
        boolean inCurly = false;
        List<StringBuilder> sbList = new ArrayList();
        sbList.add(new StringBuilder());
        List<Character> options = new ArrayList();
        for (char c : S.toCharArray()) {
            if (c == ',') {
                continue;
            } else if (c == '{') {
                inCurly = true;
                options.clear();
            } else if (c == '}') {
                inCurly = false;
                List<StringBuilder> tmp = new ArrayList();
                for (StringBuilder sb : sbList) {
                    for (char o : options) {
                        StringBuilder nSb = new StringBuilder(sb);
                        nSb.append(o);
                        tmp.add(nSb);
                    }
                }
                sbList = tmp;
            } else if (inCurly) {
                options.add(c);
            } else {
                for (StringBuilder sb : sbList) {
                    sb.append(c);
                }
            }
        }
        List<String> ans = new ArrayList();;
        for (StringBuilder sb : sbList) {
            ans.add(sb.toString());
        }
        Collections.sort(ans);
        return ans.toArray(new String[ans.size()]);
    }
}