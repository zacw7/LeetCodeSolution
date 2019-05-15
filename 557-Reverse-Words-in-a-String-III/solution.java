class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i].toCharArray());
        }
        return String.join(" ", words);
    }

    private String reverse(char[] word) {
        int l = 0, r = word.length - 1;
        while (l < r) {
            char tmp = word[l];
            word[l] = word[r];
            word[r] = tmp;
            l++;
            r--;
        }
        return new String(word);
    }
}