class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null) return false;
        int p1 = 0, p2 = 0;
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (p2 > 0 && typed.charAt(p2) == typed.charAt(p2 - 1)) {
                    p2++;
                } else {
                    return false;
                }
            }
        }
        if (p1 < name.length()) {
            return false;
        }
        while (p2 > 0 && p2 < typed.length() && typed.charAt(p2) == typed.charAt(p2 - 1)) {
            p2++;
        }
        return p2 == typed.length();
    }
}