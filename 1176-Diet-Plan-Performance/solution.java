class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int l = 0, r = k - 1;
        int cur = 0;
        for (int i = l; i < r; i++) {
            cur += calories[i];
        }
        int point = 0;
        while (r < calories.length) {
            cur += calories[r++];
            point += calc(cur, lower, upper);
            cur -= calories[l++];
        }
        return point;
    }

    int calc(int cur, int lower, int upper) {
        if (cur < lower) {
            return -1;
        } else if (cur > upper) {
            return 1;
        } else {
            return 0;
        }
    }
}