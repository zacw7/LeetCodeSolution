class Solution {

    private String[][] VALID_PAIRS = {{"0", "0"}, {"1", "1"}, {"6", "9"},
            {"8", "8"}, {"9", "6"}};

    public int strobogrammaticInRange(String low, String high) {
        List<String> listOdd = new ArrayList(), listEven = new ArrayList();
        listEven.add("");
        listOdd.add("0");
        listOdd.add("1");
        listOdd.add("8");
        int[] ans = {0};
        helper(low, high, 0, listEven, ans);
        helper(low, high, 1, listOdd, ans);
        return ans[0];
    }

    private void helper(String low, String high, int n, List<String> list, int[] ans) {
        if (n >= low.length() && n <= high.length()) {
            for (String s : list) {
                if (isValid(s, low, high)) ans[0]++;
            }
        }
        if (n + 2 <= high.length()) {
            List<String> cur = new ArrayList();
            for (String s : list) {
                for (String[] pair : VALID_PAIRS) {
                    cur.add(pair[0] + s + pair[1]);
                }
            }
            helper(low, high, n + 2, cur, ans);
        }
    }

    private boolean isValid(String s, String low, String high) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        if (s.length() < low.length() || s.length() > high.length()) return false;
        if (s.length() > low.length() && s.length() < high.length()) return true;
        if (s.length() == low.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) > low.charAt(i)) break;
                else if (s.charAt(i) < low.charAt(i)) return false;
            }
        }
        if (s.length() == high.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < high.charAt(i)) break;
                else if (s.charAt(i) > high.charAt(i)) return false;
            }
        }
        return true;
    }
}