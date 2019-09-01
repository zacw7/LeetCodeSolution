class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList();
        int[][] count = new int[256][s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            char cur = s.charAt(i - 1);
            for (char c = 'a'; c <= 'z'; c++) {
                count[c][i] = count[c][i - 1];
                if (c == cur) {
                    count[c][i]++;
                }
            }
        }
        for (int[] q : queries) {
            res.add(canMakePali(count, q[0], q[1], q[2]));
        }
        return res;
    }

    private boolean canMakePali(int[][] count, int start, int end, int change) {
        change *= 2;
        if ((end - start + 1) % 2 > 0) {
            change += 1;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            int cur = count[c][end + 1] - count[c][start];
            if (cur % 2 > 0) {
                change--;
            }
            if (change < 0) {
                return false;
            }
        }
        return true;
    }
}