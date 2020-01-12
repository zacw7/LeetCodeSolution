class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 2; j <= text.length(); j += 2) {
                String s = text.substring(i, j);
                if (isValid(s)) {
                    set.add(s);
                }
            }
        }
        return set.size();
    }

    private boolean isValid(String s) {
        int N = s.length();
        if (N % 2 > 0) {
            return false;
        }
        N /= 2;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != s.charAt(i + N)) {
                return false;
            }
        }
        return true;
    }
}