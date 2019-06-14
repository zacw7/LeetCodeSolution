class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList();
        for (int i = 2; i < S.length() - 1; i++) {
            String s1 = S.substring(1, i), s2 = S.substring(i, S.length() - 1);
            List<String> l1 = ambiguousNums(s1);
            List<String> l2 = ambiguousNums(s2);
            for (String n1 : l1) {
                for (String n2 : l2) {
                    ans.add("(" + n1 + ", " + n2 + ")");
                }
            }
        }
        return ans;
    }

    private List<String> ambiguousNums(String S) {
        List<String> ans = new ArrayList();
        boolean nonZeroNumFound = false;
        for (char c : S.toCharArray()) {
            if (c != '0') {
                nonZeroNumFound = true;
                break;
            }
        }
        if (S.length() == 1) {
            ans.add(S);
        } else if (S.length() > 1 && nonZeroNumFound) {
            if (S.charAt(0) == '0') {
                if (S.charAt(S.length() - 1) != '0') {
                    ans.add("0." + S.substring(1));
                }
            } else {
                ans.add(S);
                if (S.charAt(S.length() - 1) != '0') {
                    for (int i = 1; i < S.length(); i++) {
                        ans.add(S.substring(0, i) + "." + S.substring(i));
                    }
                }
            }
        }
        return ans;
    }
}