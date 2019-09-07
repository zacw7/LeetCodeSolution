class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int N = phrases.length;
        Set<String> res = new TreeSet();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                String str1 = phrases[i], str2 = phrases[j];
                String s1 = str1.substring(str1.lastIndexOf(" ") + 1);
                String s2 = str2;
                int k = str2.indexOf(' ');
                if (k >= 0) {
                    s2 = str2.substring(0, k);
                }
                if (s1.equals(s2)) {
                    res.add(str1 + str2.substring(s1.length()));
                }
            }
        }
        return new ArrayList(res);
    }
}