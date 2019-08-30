class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qs = new int[queries.length], ws = new int[words.length];
        for (int i = 0; i < qs.length; i++) {
            qs[i] = convert(queries[i]);
        }
        for (int i = 0; i < ws.length; i++) {
            ws[i] = convert(words[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < qs.length; i++) {
            int c = 0;
            for (int j = 0; j < ws.length; j++) {
                if (qs[i] < ws[j]) {
                    c++;
                }
            }
            ans[i] = c;
        }
        return ans;
    }

    private int convert(String s) {
        char minChar = 'z';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == minChar) {
                count++;
            } else if (c < minChar) {
                minChar = c;
                count = 1;
            }
        }
        return count;
    }
}