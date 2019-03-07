class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int count = Integer.MAX_VALUE;
        String ans = "";
        int[] plateChars = new int[26];
        for (char ch : licensePlate.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') plateChars[ch - 'a']++;
            else if (ch >= 'A' && ch <= 'Z') plateChars[ch - 'A']++;
        }
        for (String word : words) {
            if (word.length() < count) {
                int[] wordChars = new int[26];
                for (char ch : word.toCharArray()) {
                    if (ch >= 'a' && ch <= 'z') wordChars[ch - 'a']++;
                    else if (ch >= 'A' && ch <= 'Z') wordChars[ch - 'A']++;
                }
                boolean completing = true;
                for (int i = 0; i < 26; i++) {
                    if (plateChars[i] > wordChars[i]) {
                        completing = false;
                        break;
                    }
                }
                if (completing) {
                    count = word.length();
                    ans = word;
                }
            }
        }
        return ans;
    }
}