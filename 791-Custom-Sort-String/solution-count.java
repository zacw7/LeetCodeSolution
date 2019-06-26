class Solution {
    public String customSortString(String S, String T) {
        StringBuilder ans = new StringBuilder(T.length());
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                ans.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}