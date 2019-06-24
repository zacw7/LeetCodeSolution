class Solution {
    public int shortestWay(String source, String target) {
        boolean[] seen = new boolean[26];
        for (int c : source.toCharArray()) {
            seen[c - 'a'] = true;
        }
        for (int c : target.toCharArray()) {
            if (!seen[c - 'a']) {
                return -1;
            }
        }
        int i = 0, j = 0;
        while (j < target.length()) {
            if (source.charAt(i % source.length()) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return i / source.length() + ((i % source.length() == 0) ? 0 : 1);
    }
}