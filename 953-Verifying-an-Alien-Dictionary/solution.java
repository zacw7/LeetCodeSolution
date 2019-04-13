class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 0) return false;
        int[] orderMap = new int[26];
        for (int i = 0; i < orderMap.length; i++) orderMap[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++) {
            if(!isValid(words[i - 1], words[i], orderMap)) return false;
        }
        return true;
    }

    private boolean isValid(String s1, String s2, int[] orderMap) {
        for (int i = 0; i < s1.length(); i++) {
            if (i >= s2.length()) return false;
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (orderMap[ch1 - 'a'] < orderMap[ch2 - 'a']) return true;
            if (orderMap[ch1 - 'a'] > orderMap[ch2 - 'a']) return false;
        }
        return true;
    }
}