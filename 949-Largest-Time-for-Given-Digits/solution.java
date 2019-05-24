class Solution {
    String res = "";
    public String largestTimeFromDigits(int[] A) {
        char[] time = new char[5];
        time[2] = ':';
        timeHelper(A, time, 0, new boolean[4]);
        return res;
    }

    private void timeHelper(int[] A, char[] time, int index, boolean[] used) {
        if (index == 5) {
            String cur = new String(time);
            if (res.compareTo(cur) < 0) {
                res = cur;
            }
            return;
        } else if (index == 2) {
            timeHelper(A, time, index + 1, used);
        } else {
            for (int i = 0; i < A.length; i++) {
                if (used[i]
                        || (index == 0 && A[i] > 2)
                        || (index == 1 && time[0] == '2' && A[i] > 3)
                        || (index == 3 && A[i] > 5)) {
                    continue;
                }
                used[i] = true;
                time[index] = (char)('0' + A[i]);
                timeHelper(A, time, index + 1, used);
                used[i] = false;
            }
        }
    }
}