class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) return 0;
        int count = 0;
        int slow = 0, fast = 1;
        while(fast < s.length()) {
            if (s.charAt(fast) != s.charAt(slow)) {
                count++;
                for (int offset = 1; slow - offset >= 0 && fast + offset < s.length(); offset++) {
                    if (s.charAt(slow - offset) != s.charAt(fast + offset)
                            && s.charAt(slow) == s.charAt(slow - offset)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            slow++;
            fast++;
        }
        return count;
    }
}