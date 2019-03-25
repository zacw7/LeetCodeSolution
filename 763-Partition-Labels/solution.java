class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList();
        if (S == null || S.length() == 0) return res;
        int[] endAt = new int[26];
        for (int i = 0; i < S.length(); i++) {
            endAt[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        while (start < S.length()) {
            int end = endAt[S.charAt(start) - 'a'];
            for (int i = start + 1; i < S.length() && i < end; i++) {
                int bound = endAt[S.charAt(i) - 'a'];
                if (bound > end) end = bound;
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}