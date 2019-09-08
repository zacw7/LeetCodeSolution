class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int start = 5;
        int offset = 0;
        for (int y = 1971; y < year; y++) {
            offset += 365;
            if (isSpecial(y)) {
                offset += 1;
            }
        }
        for (int m = 1; m < month; m++) {
            offset += daysOfMonth(year, m);
        }
        offset += day - 1;
        return days[(offset + 5) % 7];
    }

    int[] MON = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private int daysOfMonth(int y, int m) {
        if (m == 2) {
            if (isSpecial(y)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return MON[m - 1];
        }
    }

    private boolean isSpecial(int y) {
        if (y % 100 == 0) {
            return y % 400 == 0;
        } else {
            return y % 4 == 0;
        }
    }
}