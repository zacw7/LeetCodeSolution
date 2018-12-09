class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        boolean isUpper = false;
        if (Character.isUpperCase(word.charAt(0))) {
            isUpper = Character.isUpperCase(word.charAt(1));
        } else {
            if (Character.isUpperCase(word.charAt(1))) {
                return false;
            }
        }
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) != isUpper) {
                return false;
            }
        }
        return true;
    }
}