class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int a : ages) {
            count[a]++;
        }
        int req = 0;
        for (int a = 1; a <= 120; a++) {
            if (count[a] == 0) {
                continue;
            }
            for (int b = 1; b <= 120; b++) {
                if (b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)) {
                    continue;
                }
                if (a == b) {
                    req += count[a] * (count[b] - 1);
                } else {
                    req += count[a] * count[b];
                }
            }
        }
        return req;
    }
}