class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        int N = p.length();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = i - N + 1;
            count[s.charAt(i) - 'a']++;
            if (j >= 0) {
                if (isValid(count, target)) {
                    res.add(j);
                }
                count[s.charAt(j) - 'a']--;
            }
        }
        return res;
    }

    private boolean isValid(int[] count, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}