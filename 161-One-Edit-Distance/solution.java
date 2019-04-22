class Solution {
    // one-pass
    // T: O(n)
    // S: O(1)
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            // if s.length() == t.length(), then one edit distance must be replace
            boolean placed = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (placed) {
                        return false;
                    } else {
                        placed = true;
                    }
                }
            }
            return placed;
        } else {
            // if s.length() > t.length(), then one edit distance must be delete a character from s to get t
            // and vice versa
            // make s be the longer one
            if (s.length() < t.length()) {
                String tmp = s;
                s = t;
                t = tmp;
            }
            int p1 = 0, p2 = 0;
            boolean inserted = false;
            while (p1 < s.length()) {
                if (p2 < t.length() && s.charAt(p1) == t.charAt(p2)) {
                    p1++;
                    p2++;
                } else {
                    if (inserted) {
                        return false;
                    }
                    inserted = true;
                    p1++;
                }
            }
            return inserted;
        }
    }
}