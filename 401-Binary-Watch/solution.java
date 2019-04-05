class Solution {

    List<String> ans;

    public List<String> readBinaryWatch(int num) {
        ans = new ArrayList();
        boolean[] led = new boolean[10];
        helper(led, 0, num);
        return ans;
    }

    private void helper(boolean[] led, int cur, int num) {
        if (num == 0) {
            validate(led);
        } else {
            if (cur >= led.length) return;
            for (int i = cur; i < led.length; i++) {
                led[i] = true;
                helper(led, i + 1, num - 1);
                led[i] = false;
            }
        }
    }

    private void validate(boolean[] led) {
        StringBuilder sb = new StringBuilder();
        int hour = 0, minute = 0;
        for (int i = 0; i < 4; i++) {
            hour *= 2;
            if (led[i]) hour += 1;
        }
        if (hour >= 0 && hour <= 11) sb.append(String.valueOf(hour)).append(':');
        else return;
        for (int i = 4; i < 10; i++) {
            minute *= 2;
            if (led[i]) minute += 1;
        }
        if (minute >= 0 && minute <= 9)
            sb.append('0').append(String.valueOf(minute));
        else if (minute >= 10 && minute <= 59)
            sb.append(String.valueOf(minute));
        else return;
        ans.add(sb.toString());
    }
}