class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                if (i - w.length() >= 0
                        && memo[i - w.length()]
                        && w.equals(s.substring(i - w.length(), i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}