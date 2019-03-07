class Solution {
    public List<String> commonChars(String[] A) {
        int[][] dict = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (char c : A[i].toCharArray()) {
                dict[i][c - 'a']++;
            }
        }
        List<String> ans = new ArrayList();
        for (int i = 0; i < 26; i++) {
            int count = dict[0][i];
            String ch = String.valueOf((char)('a' + i));
            for (int j = 1; j < A.length; j++) {
                count = (dict[j][i] < count) ? dict[j][i] : count;
            }
            while (count-- > 0) {
                ans.add(ch);
            }
        }
        return ans;
    }
}