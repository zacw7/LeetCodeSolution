class Solution {
    public int repeatedStringMatch(String A, String B) {
        int[] chars = new int[26];
        for (char c : A.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : B.toCharArray()) {
            if (chars[c - 'a'] == 0) {
                return -1;
            }
        }
        int count = 0;
        String S = "";
        while (S.length() < B.length()) {
            S = S + A;
            count++;
        }

        do {
            if (S.indexOf(B) >= 0) {
                return count;
            }
            S = S + A;
            count++;
        } while (S.length() < B.length() * 2);

        if (S.indexOf(B) >= 0) {
            return count;
        }

        return -1;
    }
}