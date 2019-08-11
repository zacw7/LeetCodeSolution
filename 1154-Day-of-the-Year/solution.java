class Solution {
    public int dayOfYear(String date) {
        int[] dayOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strs = date.split("-");
        int year = Integer.valueOf(strs[0]);
        int month = Integer.valueOf(strs[1]);
        int day = Integer.valueOf(strs[2]);
        if (isSpe(year)) {
            dayOfMonth[1] = 29;
        }
        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += dayOfMonth[i - 1];
        }
        return ans + day;
    }

    private boolean isSpe(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }

}