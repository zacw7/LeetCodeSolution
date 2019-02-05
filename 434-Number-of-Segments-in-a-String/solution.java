class Solution {
    public int countSegments(String s) {
        s = s.trim().replaceAll("[ ]+", " ");
        return (s.length() > 0) ? s.split(" ").length : 0;
    }
}