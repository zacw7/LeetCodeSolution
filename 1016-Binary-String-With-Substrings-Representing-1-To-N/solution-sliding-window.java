class Solution {
    // sliding window
    // TC: O(N)
    // SC: O(N)
    public boolean queryString(String S, int N) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < S.length(); i++) {
            for (int j = i; j >= 0 && i - j < 31; j--) {
                if (S.charAt(j) != '0') {
                    int n = Integer.parseInt(S.substring(j, i + 1), 2);
                    if (n <= N) {
                        seen.add(n);
                    }
                }
            }
            if (seen.size() == N) {
                return true;
            }
        }
        return false;
    }
}