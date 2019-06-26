class Solution {
    public String customSortString(String S, String T) {
        int[] order = new int[26];
        for (int i = 0; i < S.length(); i++) {
            order[S.charAt(i) - 'a'] = i + 1;
        }

        Character[] chs = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            chs[i] = T.charAt(i);
        }
        Arrays.sort(chs, (a, b) -> order[a - 'a'] - order[b - 'a']);
        StringBuilder ans = new StringBuilder(T.length());
        for (char c : chs) {
            ans.append(c);
        }
        return ans.toString();
    }
}