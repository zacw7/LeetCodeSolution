class Solution {
    public int countSubstrings(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char ch : s.toCharArray()) sb.append(ch).append('#');
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            int cur = 1;
            for (int offset = 1;
                 i - offset >= 0
                         && i + offset < sb.length()
                         && sb.charAt(i - offset) == sb.charAt(i + offset);
                 offset++) {
                cur++;
            }
            count += cur / 2;
        }
        return count;
    }
}