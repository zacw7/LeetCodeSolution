class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null || word.length() == 0 || abbr.length() == 0) {
            return false;
        }

        int p1 = 0, p2 = 0;
        while (p2 < abbr.length()) {
            if (Character.isDigit(abbr.charAt(p2))) {
                int num = abbr.charAt(p2++) - '0';
                if (num == 0) {
                    return false;
                }
                while (p2 < abbr.length() && Character.isDigit(abbr.charAt(p2))) {
                    num *= 10;
                    num += abbr.charAt(p2++) - '0';
                }
                p1 += num;
            } else {
                if (p1 >= word.length() || word.charAt(p1) != abbr.charAt(p2)) {
                    return false;
                } else {
                    p1++;
                    p2++;
                }
            }
        }
        return p1 == word.length();
    }
}