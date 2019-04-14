class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        backtracking(s, 0, new ArrayList(), ans);
        return ans;
    }

    private void backtracking(String s, int index, List<String> cur, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(cur);
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                String str = s.substring(index, i);
                if (isPalindrome(str)) {
                    List<String> list = new ArrayList(cur);
                    list.add(str);
                    backtracking(s, i, list, ans);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }
}