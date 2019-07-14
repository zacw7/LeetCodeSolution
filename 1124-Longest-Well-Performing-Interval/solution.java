class Solution {
    public int longestWPI(int[] hours) {
        int[] prefix = new int[hours.length + 1];
        for (int i = 1; i <= hours.length; i++) {
            prefix[i] = prefix[i - 1];
            if (hours[i - 1] > 8) {
                prefix[i] += 1;
            }
        }
        int max = 0;
        for (int i = 1; i < prefix.length; i++) {
            for (int j = i - max; j > 0; j--) {
                int len = i - j + 1;
                int tr = prefix[i] - prefix[j - 1], n_tr = len - tr;
                if (tr > n_tr) {
                    max = len;
                }
            }
        }
        return max;
    }
}