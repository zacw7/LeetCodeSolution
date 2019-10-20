class Solution {
    public int balancedString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length() / 4;
        int[] target = new int[4];
        s = s.replaceAll("Q", "A").replaceAll("W", "B").replaceAll("E", "C").replaceAll("R", "D");
        for (int c : s.toCharArray()) {
            target[c - 'A']++;
        }
        for (int i = 0; i < 4; i++) {
            if (target[i] <= n) {
                target[i] = 0;
            } else {
                target[i] -= n;
            }
        }
        boolean quickCheck = true;
        for (int t : target) {
            if (t > 0) {
                quickCheck = false;
            }
        }
        if (quickCheck) {
            return 0;
        }
        int[] cur = new int[4];
        int l = 0, r = 0;
        int minLen = s.length();
        while (r < s.length()) {
            cur[s.charAt(r) - 'A']++;
            r++;
            while (l < r && isValid(cur, target)) {
                minLen = Math.min(minLen, r - l);
                cur[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return minLen;
    }

    private boolean isValid(int[] cur, int[] target) {
        for (int i = 0; i < 4; i++) {
            if (cur[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}