class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}