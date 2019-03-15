class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() == b.length()) {
            return (a.equals(b)) ? -1 : a.length();
        } else {
            return Math.max(a.length(), b.length());
        }
    }
}