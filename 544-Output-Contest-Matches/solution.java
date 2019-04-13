class Solution {
    // T: O(NlogN)
    // S: O(N)
    public String findContestMatch(int n) {
        List<String> matches = new ArrayList();
        for (int i = 1; i <= n; i++) matches.add(String.valueOf(i));
        while (matches.size() > 1) {
            List<String> next = new ArrayList();
            for (int i = 0; i < matches.size() / 2; i++) {
                next.add("(" + matches.get(i) + ","
                        + matches.get(matches.size() - 1 - i) + ")");
            }
            matches = next;
        }
        return matches.get(0);
    }
}