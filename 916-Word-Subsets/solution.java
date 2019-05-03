class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return res;
        }
        int[] target = new int[26];
        for (String s : B) {
            int[] cur = new int[26];
            for (char c : s.toCharArray()) {
                cur[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                target[i] = Math.max(target[i], cur[i]);
            }
        }
        for (String s : A) {
            int[] source = new int[26];
            for (char c : s.toCharArray()) {
                source[c - 'a']++;
            }
            if (isValid(source, target)) {
                res.add(s);
            }
        }
        return res;
    }

    private boolean isValid(int[] source, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (source[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}